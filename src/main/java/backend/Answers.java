package backend;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Answers {

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

	public ArrayList<String> getFalse(String wiki, String subjectTemp, String[] correct) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		df.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		String subject = null;
		try {
			subject = Normalizer.normalize(URLEncoder.encode(subjectTemp, "UTF-8"), Normalizer.Form.NFKC);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> answers = new HashSet<String>();
		for (int j = 0; j < correct.length; j++) {
			answers.add(correct[j]);
		}
		String get = "api.php?action=ask&format=xml&query=[[" + subject + "::%2B]]|?" + subject;
		Document doc = null;
		try {
			doc = getHTML(wiki, get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList tempList = doc.getElementsByTagName("value");
		if (subject.contains("ckgabe")) {
			System.out.println(subject);
		}
		for (int i = 0; i < tempList.getLength(); i++) {
			Node tempNode = tempList.item(i);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) tempNode;
				if (e.getTextContent() != "") {
					if (subject.contains("dat") || subject.contains("DAT") || subject.contains("Dat")
							|| subject.contains("Tag") || subject.contains("Ende") || subject.contains("ckgabe")
							|| subject.contains("Beginn")) {
						Date date = new Date(Long.valueOf(e.getTextContent()).longValue() * 1000L);
						answers.add(df.format(date));

					} else {
						answers.add(
								e.getTextContent().split(":")[e.getTextContent().split(":").length - 1].split("#")[0]);
					}
				} else {
					if (subject.contains("dat") || subject.contains("DAT") || subject.contains("Dat")
							|| subject.contains("Tag") || subject.contains("Ende") || subject.contains("ckgabe")
							|| subject.contains("Beginn")) {
						Date date = new Date(Long.valueOf(e.getAttribute("fulltext")).longValue() * 1000L);
						answers.add(df.format(date));
					} else if (subject.contains("HatKoordinaten")) {
						answers.add(e.getAttribute("lat") + "," + e.getAttribute("lon"));
					} else {
						answers.add(
								e.getAttribute("fulltext").split(":")[e.getAttribute("fulltext").split(":").length - 1]
										.split("#")[0]);
					}
				}
			}
			for (int j = 0; j < correct.length; j++) {
				answers.remove(correct[j]);
			}
		}
		ArrayList<String> answerList = new ArrayList<String>();
		for (String answer : answers) {
			System.out.println("Alternative Antworten" + answer);
			answerList.add(answer);
		}
		return answerList;

	}
}
