package backend;

public class Generator {
	int j = 1;
	String correctAnswer;
	String property;

	public String questGen(String wiki) {
		String quest = "Question Number" + j;
		j++;
		setCorrectAnswer(String.valueOf(Math.random()*100));
		return quest;
	}

	public String answerGen() {
		double i = Math.random();
		String answer = String.valueOf(i);
		
		return answer;

	}

	public void setCorrectAnswer(String answer){
		correctAnswer = answer;
	}
	public String getCorrectAnswer(){
		return correctAnswer;
	}
}
