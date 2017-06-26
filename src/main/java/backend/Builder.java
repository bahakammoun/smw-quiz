package backend;

public class Builder {
	public PageSaver pageSaver = new PageSaver();
	public Builder(PageSaver page) {
		pageSaver = page;
	}

	public String buildQuest(String wiki, int questions, int answers) {
		
		GeneratorReal generator = new GeneratorReal(pageSaver);

		String giveMeBack = "{ \"fullQuiz\" : [ ";
		try{
		for (int i = 0; i < questions; i++) {
			int rnd = (int) (Math.random() * answers);
			int j = i + 1;
			int n = 0;
			giveMeBack = giveMeBack + "{ \"qId\": \"q" + j + "\", \"Question\": \"" + generator.questGen(wiki)
					+ "\", \"rightAnswer\": \"" + generator.getCorrectAnswer() + "\", \"PossibleAnswers\": [";
			for (int k = 0; k < rnd; k++) {
				n++;
				giveMeBack = giveMeBack + "{ \"aId\" : \"q" + j + "\", \"Answer\":\"" + generator.answerGen() + "\" },";
			}
			if (answers != 0) {
				giveMeBack = giveMeBack + "{ \"aId\" : \"q" + j + "\", \"Answer\":\""
						+ generator.getCorrectAnswerSingle() + "\" }";
				n++;
			}
			if (n != answers) {
				giveMeBack += ",";
			}
			for (int m = 1; m < answers - rnd; m++) {
				n++;
				giveMeBack = giveMeBack + "{ \"aId\" : \"q" + j + "\", \"Answer\":\"" + generator.answerGen() + "\" }";
				if (n != answers) {
					giveMeBack += ",";
				}
			}

			giveMeBack = giveMeBack + "] }";
			if (j != questions) {
				giveMeBack = giveMeBack + ",";
			} else {
				giveMeBack = giveMeBack + "] }";
			}

		}

		
		}catch (Exception e) {
			giveMeBack = "{ \"fullQuiz\" : [ { \"qId\": \"q1\", \"Question\": \"YourSMW link is not valid, or the SWM is offline. Please check.\", \"rightAnswer\": \"Try Again\", \"PossibleAnswers\": [";
			for (int i = 0; i<answers ; i++){
				giveMeBack += "{ \"aId\" : \"q1\", \"Answer\":\"NotAvailable\" }";
				if (i != answers-1) {
					giveMeBack += ";";
				}
			}
			giveMeBack += "] }] }";
			
		}
		return giveMeBack;
	}
}
