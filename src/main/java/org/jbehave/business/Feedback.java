package org.jbehave.business;

public class Feedback {

	private String sender;
	private String recipient;
	private String feedbackDescription;
	
	public Feedback(String sender, String recipient, String feedbackDescription) {
		this.sender = sender;
		this.recipient = recipient;
		this.feedbackDescription = feedbackDescription;

	}


    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }
}
