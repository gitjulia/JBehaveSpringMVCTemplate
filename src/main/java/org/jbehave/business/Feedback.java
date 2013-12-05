package org.jbehave.business;

public class Feedback {

	private String recipient = "0";
	private String feedback = "0";
	
	public Feedback(String recipient) {
		this.recipient = recipient;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
