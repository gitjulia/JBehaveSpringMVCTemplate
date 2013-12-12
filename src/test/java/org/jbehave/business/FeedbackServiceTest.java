package org.jbehave.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

public class FeedbackServiceTest {

    FeedbackService feedbackService = new FeedbackServiceImpl();

    @Test
    public void testAddNewFeedback(){
        assertThat(feedbackService.getFeedbacks().size(), is(0));
        feedbackService.addNewFeedback(anyString(), anyString(), anyString());
        feedbackService.addNewFeedback(anyString(), anyString(), anyString());
        feedbackService.addNewFeedback(anyString(), anyString(), anyString());
        assertThat(feedbackService.getFeedbacks().size(), is(3));
    }

    @Test
    public void testSearchFeedbackByRecipient(){
        boolean containsOtherRecipientFeedback = false;
        assertThat(feedbackService.getFeedbacks().size(), is(0));
        feedbackService.addNewFeedback("sender", "recipient", "feedback");
        feedbackService.addNewFeedback("sender2", "recipient2", "feedback2");
        List<Feedback> feedbackList = feedbackService.getFeedbacksByRecpient("sender");
        for(Feedback feedback : feedbackList){
            if(!feedback.getRecipient().equals("recipient")){
                containsOtherRecipientFeedback = true;
                break;
            }
        }
        assertFalse(containsOtherRecipientFeedback);

    }
}
