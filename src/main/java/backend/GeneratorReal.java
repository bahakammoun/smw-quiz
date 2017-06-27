package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class GeneratorReal {
	int j = 1;
	int k;
	String correctAnswer;
	String property;
	ArrayList<String> falseAnswer;
	PageSaver pageSaver = new PageSaver();

	public GeneratorReal(PageSaver page) {
		pageSaver = page;
	}

	public String questGen(String wiki) {
		falseAnswer = null;
		k = 0;
		String quest = "";
		Pages pages = new Pages();
		Prop prop = new Prop();
		Answers answers = new Answers();
		Boolean temp = false;
		ArrayList<String> page = null;
		if (pageSaver.getTime(wiki) < 86400000) {
			page = pageSaver.getPages(wiki);
		} else {
			page = pages.getPages(wiki);
			pageSaver.savePage(wiki, pages.getPages(wiki));

		}
		HashMap<String, Set<String>> property = new HashMap<String, Set<String>>();
		String tempArray[] = null;
		String singlePage = "";
		while (temp == false) {
			int r = (int) (Math.random() * page.size());
			singlePage = page.get(r);

			System.out.println("Page" + r + singlePage);
			property = prop.getProp(wiki, singlePage);

			Random nextR = new Random();
			ArrayList<String> keys = new ArrayList<String>(property.keySet());
			if (property.size() != 0) {
				temp = true;
				System.out.println("prop size" + property.size());

				setProperty(keys.get(nextR.nextInt(keys.size())));
				System.out.println("ChoosenProperty: " + getProperty());
				Set<String> value = property.get(getProperty());
				String answer = "";
				tempArray = value.toArray(new String[value.size()]);
				for (int j = 0; j < value.size(); j++) {
					answer += tempArray[j];
					System.out.println("CorrectAnswerPossible" + tempArray[j]);
					if (j != value.size()) {
						answer += "; ";
					}
				}
				setCorrectAnswer(answer);
			}
		}

		falseAnswer = answers.getFalse(wiki, getProperty(), tempArray);
		if (getProperty().equals("GivenName")) {
			singlePage = singlePage.split(" ")[1];
		} else if (getProperty().equals("FamilyName")) {
			singlePage = singlePage.split(" ")[0];
		}
		System.out.println("Was ist " + getProperty().replace("_", "") + " von " + singlePage + "?");
		String label = prop.getFact(wiki, getProperty(), "label");
		String start = prop.getFact(wiki, getProperty(), "Unterattribut_von");
		
		if (label == null || start == null) {
			quest = "Was ist " +  getProperty().replace("_", "") + " von " + singlePage + "?";
			return quest;
		}
		
		String tail = label + " " + singlePage + "?";
		if (label.contains("+")) {
			tail = label.replace("+", singlePage) + "?";
		}
		
		String mid = " ";
		
		if (label.startsWith("9")) {
			tail = tail.substring(1, tail.length());
			mid = "";
		}
		
		
		quest = "Was ist " +  getProperty().replace("_", "") + " von " + singlePage + "?"; 

		quest = start + mid + tail;
		
		return quest;
	}

	public String answerGen() {
		String answer = null;
		if (k < falseAnswer.size()) {
			answer = falseAnswer.get(k);
			k++;
		} else {
			answer = "NotAvailable";
		}
		System.out.println("FalscheAntwort " + answer);
		return answer;

	}

	public void setCorrectAnswer(String answer) {
		correctAnswer = answer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String getCorrectAnswerSingle() {
		String temp[] = correctAnswer.split("; ");
		int t = (int) (temp.length * Math.random());
		String hashTag = temp[t].split("#")[0];
		String dDot = hashTag.split(":")[hashTag.split(":").length - 1];
		dDot.replaceAll("_", " ");
		if (dDot.replace(" ", "").length() < 1) {
			dDot = getCorrectAnswerSingle();
		}
		System.out.println("CorrectAnswer: " + dDot);
		return dDot;
	}

	public void setFalse(ArrayList<String> answer) {
		falseAnswer = answer;
	}

	public ArrayList<String> getFalse() {
		return falseAnswer;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String set) {
		property = set;
	}
}
