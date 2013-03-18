package beans;

public class Answer {
	private String sentence;
	private boolean isFalse;
	
	
	public Answer(String sentence, boolean isFalse) {
		super();
		this.sentence = sentence;
		this.isFalse = isFalse;
	}


	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}


	public boolean isFalse() {
		return isFalse;
	}


	public void setFalse(boolean isFalse) {
		this.isFalse = isFalse;
	}


	@Override
	public String toString() {
		return "Answer [sentence=" + sentence + ", isFalse=" + isFalse + "]";
	}
	
	
	
	
	
	
}
