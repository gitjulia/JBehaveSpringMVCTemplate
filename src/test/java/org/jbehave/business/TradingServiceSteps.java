package org.jbehave.business;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceSteps {

    @Autowired
    FeedbackService feedbackService;
    Feedback fakeFeedback;

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        fakeFeedback = feedbackService.addNewFeedback("myName", "anotherPerson", "Yay!");
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        Feedback returnedFeedback = findFeedback(fakeFeedback);
        assertThat(returnedFeedback.getFeedbackDescription(), is("Yay!"));
    }

    @Then("I should see the recipient’s name")
    public void viewRecipient() {
        Feedback returnedFeedback = findFeedback(fakeFeedback);
        assertThat(returnedFeedback.getRecipient(), is("anotherPerson"));

    }

    @Then("I should see my name")
    public void viewSender() {
        Feedback returnedFeedback = findFeedback(fakeFeedback);
        assertThat(returnedFeedback.getSender(), is("myName"));
    }

    private Feedback findFeedback(Feedback feedbackToFind) {
        List<Feedback> feedbackList = feedbackService.getFeedbacks();
        return feedbackList.get(feedbackList.indexOf(feedbackToFind));
    }


}
