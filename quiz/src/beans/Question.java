package beans;

import java.util.List;

public class Question {

	private String wording;
	private List<Answer> answers;


	public Question(String wording, List<Answer> answers) {
		super();
		this.wording = wording;
		this.answers = answers;
	}
	
	public Question(String wording) {
		this.wording = wording;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [wording=" + wording + ", answers=" + answers + "]";
	}
	
	


}
