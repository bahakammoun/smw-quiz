package backend;

import org.w3c.dom.*;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Pages {

	public Document getHTML(String wiki, String get) throws Exception {
		String urlString = wiki + get;
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(con.getInputStream());
		return doc;
	}

	public ArrayList<String> getPages(String wiki) {
		String get = "api.php?action=query&format=xml&list=allpages&continue&aplimit=100";
		String contin = "";
		Document doc = null;
		ArrayList<String> pages = new ArrayList<String>();
		try {
			doc = getHTML(wiki, get + contin);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList Lnode = doc.getElementsByTagName("continue");
		NodeList nList = doc.getElementsByTagName("p");
		if (Lnode.getLength() != 0) {
			Node n = Lnode.item(0);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) Lnode.item(0);
				contin = "&apcontinue=" + e.getAttribute("apcontinue");
			}
		}
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element nElement = (Element) nNode;
				pages.add(nElement.getAttribute("title"));
			}
		}
		while (Lnode.getLength() != 0) {
			try {
				doc = getHTML(wiki, get + contin);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			doc.getDocumentElement().normalize();
			Lnode = doc.getElementsByTagName("continue");
			nList = doc.getElementsByTagName("p");
			if (Lnode.getLength() != 0) {
				Node n = Lnode.item(0);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) Lnode.item(0);
					contin = "&apcontinue=" + e.getAttribute("apcontinue");
				}
			}
			for (int j = 0; j < nList.getLength(); j++) {
				Node nNode = nList.item(j);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element nElement = (Element) nNode;
					AllPages p = new AllPages();
					String test = Normalizer.normalize(nElement.getAttribute("title"), Normalizer.Form.NFKC);
					test = test.replaceAll("\u00E4", "a");
					test = test.replaceAll("\u00F6", "o");
					test = test.replaceAll("\u00FC", "u");
					if (p.pages(wiki).contains(test) == false) {
						pages.add(nElement.getAttribute("title"));
					}
				}
			}
		}
		System.out.println(pages.size());
		return pages;

	}

}
