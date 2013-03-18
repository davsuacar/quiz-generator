package beans;

import java.util.List;

public class Exam {
	private List<Question> questions;

	public Exam(List<Question> questions) {
		super();
		this.questions = questions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
