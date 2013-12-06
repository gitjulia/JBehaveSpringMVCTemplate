package org.jbehave.business;


public interface FeedbackService {

	public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription);
	
}
