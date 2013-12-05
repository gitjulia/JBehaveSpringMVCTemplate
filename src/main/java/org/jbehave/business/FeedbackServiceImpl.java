package org.jbehave.business;

import org.springframework.stereotype.Component;

@Component
public class FeedbackServiceImpl implements FeedbackService {

	public Feedback addNewFeedback(String threshold, String tradeAt) {
        Feedback feedback = new Feedback(threshold);
        feedback.setFeedback(tradeAt);
        return feedback;
	}

}
