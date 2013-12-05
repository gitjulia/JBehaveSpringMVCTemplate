package org.jbehave.web;

import org.jbehave.business.Steps;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceWebSteps {

    @BeforeStories
    public void openApp() {
        insertStockPage.open();
    }

    @AfterStories
    public void tearDown() {
        insertStockPage.close();
    }

	@Autowired
	@Qualifier("insertStockPage")
	private InsertStockPage insertStockPage;

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        insertStockPage.fillFeedback("myName", "anotherPerson", "Yay!");
        insertStockPage.submitForm();
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        assertThat(insertStockPage.viewFeedback("feedback_1"), containsString("Yay!"));
    }

    @Then("I should see the recipient’s name")
    public void viewRecipient() {
        assertThat(insertStockPage.viewRecipient("recipient_1"), containsString("anotherPerson"));
    }


}
