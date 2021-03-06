package backend;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Prop {
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

	public String getFact(String wiki, String property, String fact) {
		
		String get = null;
		
		String content = "[[Attribut:" + property + "]]|?" + fact; 
		
		try {
			
			get = "api.php?action=ask&format=xml&query=" + URLEncoder.encode(content, "UTF-8");
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Document doc = null;
		try {
			doc = getHTML(wiki, get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (doc == null) {
			return null;
		}
		
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("value");
		if (nList == null || nList.getLength() == 0) {
			return null;
		}
		Element e = null;
		e = (Element) nList.item(0);
	
		System.out.println("Docoooooooo");
		System.out.println(doc.toString());
		
		if (e == null || !e.hasAttribute("fulltext")) {
			return null;
		}
		
		String value = e.getAttribute("fulltext");
		
		if (value.startsWith("Attribut:")) {
			value = value.replaceFirst("Attribut:", "");
		}
		System.out.println("TESTOOOOOOOOO " + value);
		
		return value;
	}
	
	public HashMap<String, Set<String>> getProp(String wiki, String subject) {
		HashMap<String, Set<String>> property = new HashMap<String, Set<String>>();
		Set<String> value = new HashSet<String>();
		String prop = null;
		String get = null;
		try {
			get = "api.php?action=browsebysubject&format=xml&subject=" + URLEncoder.encode(subject, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = null;
		try {
			doc = getHTML(wiki, get);
		} catch (Exception e) {
			e.printStackTrace();
		}

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("data");
		nList = nList.item(0).getChildNodes();
		Element e = null;
		System.out.println("nListsize" + nList.getLength());
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				e = (Element) nNode;
				prop = e.getAttribute("property");
				value = new HashSet<String>();
				NodeList tempList = e.getElementsByTagName("value");
				for (int j = 0; j < tempList.getLength(); j++) {
					Node tempNode = tempList.item(j);
					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
						Element temp = (Element) tempNode;
						String answer = (temp.getAttribute("item").split("#")[0]).replace("_", " ");
						System.out.println(answer);
						if (answer.startsWith("1/20") || answer.startsWith("1/19")) {
							String tempString[] = answer.split("/");
							System.out.println("DeBug: " + tempString[0] + " " + tempString[0]);
							if (tempString.length < 4) {
								String[] newTemp = new String[4];
								newTemp[0] = tempString[0];
								newTemp[1] = tempString[1];
								newTemp[2] = "0";
								newTemp[3] = "0";
								tempString = newTemp;
							}
							if (Integer.parseInt(tempString[2]) < 10) {
								tempString[2] = "0" + tempString[2];
							}
							if (Integer.parseInt(tempString[3]) < 10) {
								tempString[3] = "0" + tempString[3];
							}
							
							if (Integer.parseInt(tempString[2]) < 1) {
								answer = tempString[1];
							} else {
								answer = tempString[3] + "." + tempString[2] + "." + tempString[1];
							}
							
							
							
						}
						if (subject.contains(answer)==false || prop.contains("Name")) {
							System.out.println("Antwortvon" + prop + ":" + answer);
							value.add(answer);
						}
					}
				}
				if (value.size() != 0) {
					property.put(prop, value);
				}

			}

		}
		System.out.println("propertysize" + property.size());

		AllPropertys p = new AllPropertys();
		String[] blackList = p.category(wiki);
		for (int k = 0; k < blackList.length; k++) {
			property.remove(blackList[k]);
		}

		return property;
	}

}
