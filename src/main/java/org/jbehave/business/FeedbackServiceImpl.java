package org.jbehave.business;

import org.springframework.stereotype.Component;

@Component
public class FeedbackServiceImpl implements FeedbackService {

	public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription) {
        Feedback feedback = new Feedback(sender, recipient, feedbackDescription);
        return feedback;
	}

}
