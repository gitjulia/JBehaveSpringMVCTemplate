package org.jbehave.business;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedbackServiceImpl implements FeedbackService {

    private List<Feedback> feedbackList = new ArrayList<Feedback>();

	public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription) {
        Feedback feedback = new Feedback(sender, recipient, feedbackDescription);
        feedbackList.add(feedback);
        return feedback;
	}

    @Override
    public List<Feedback> getFeedbacks() {
        return feedbackList;
    }

    @Override
    public List<Feedback> getFeedbacksByRecpient(String recipient) {
        List<Feedback> list = new ArrayList<Feedback>();
        for(Feedback feedback : feedbackList){
          if(feedback.getRecipient().equals(recipient)){
              list.add(feedback);
          }
        }
        return list;
    }

}
