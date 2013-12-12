package org.jbehave.web;

import org.jbehave.business.FeedbackService;
import org.jbehave.business.Steps;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceWebSteps {

    @Autowired
    @Qualifier("FeedbackPage")
    private FeedbackPage feedbackPage;

    @Autowired
    FeedbackService feedbackService;

    @BeforeStories
    public void openApp() {
        feedbackPage.open();
    }

    @AfterStories
    public void tearDown() {
        feedbackPage.close();
    }

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        submitFeedback("myName", "anotherPerson", "Yay!");
    }

    private void searchFeedbackByRecipient(String recipient) {
        feedbackPage.fillSearchFeedbackForm(recipient);
        feedbackPage.submitSearchFeedbackForm();
    }

    private void submitFeedback(String sender, String receipient, String feedbackMessage) {
        feedbackPage.fillFeedback(sender, receipient , feedbackMessage);
        feedbackPage.submitFeedbackForm();
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        assertThat(feedbackPage.viewFeedback("feedback1"), containsString("Yay!"));
    }

    @Then("I should see the recipient’s name")
    public void viewRecipient() {
        assertThat(feedbackPage.viewRecipient("feedback1"), containsString("anotherPerson"));
    }

    @Then("I should see my name")
    public void viewSender() {
        assertThat(feedbackPage.viewSender("feedback1"), containsString("myName"));
    }

     @Given("that I have already submitted a feedback")
    public void submittedFeedback() {
         submitFeedback("myName2", "anotherPerson2", "Hello!");

     }

    @When("I try to submit another feedback")
    public void submitAnotherFeedback(){
        submitFeedback("myName3", "anotherPerson3", "Hello!");
    }

    @Then("I should see my previous feedback")
    public void viewPreviousFeedback() {
        assertThat(feedbackPage.viewFeedback("feedback1"), containsString("Hello!"));
        assertThat(feedbackPage.viewRecipient("feedback1"), containsString("anotherPerson2"));
        assertThat(feedbackPage.viewSender("feedback1"), containsString("myName2"));
    }

    @Given("that there is feedback for a specific recipient")
    public void submitFeedbackForSpecificRecipient(){
        submitFeedback("Bingo", "Eeyor", "Bingo is my nameo");
        submitFeedback("Bingo", "Old Yeller", "A Feedback");
    }

    @When("I search for that recipient's feedback")
    public void searchForFeedbackByRecipient() {
        searchFeedbackByRecipient("Eeyor");
    }
    @Then("I should see feedback only for that recipient")
    public void viewSpecificRecipientFeedback() {
        assertThat(feedbackPage.viewFeedback("feedback1"), containsString("Eeyor"));
    }
}
