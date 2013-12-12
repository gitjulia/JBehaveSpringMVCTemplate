package org.jbehave.business;


import java.util.List;

public interface FeedbackService {

	public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription);

    List<Feedback> getFeedbacks();

    List<Feedback> getFeedbacksByRecpient(String recipient);
}
