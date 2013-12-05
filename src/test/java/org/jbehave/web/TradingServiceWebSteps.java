package org.jbehave.web;

import org.jbehave.business.Steps;
import org.jbehave.business.StockAlertStatus;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceWebSteps {

	@Autowired
	@Qualifier("insertStockPage")
	private InsertStockPage insertStockPage;
	@Autowired
	@Qualifier("showStatusStockPage")
	private ShowStockStatusPage showStockStatusPage;
	
	@Given("trader starts web application")
	public void aNewStockCreated() {
		insertStockPage.open();
	}

    @Given("I start the web application")
	public void newWebApp() {
		insertStockPage.open();
	}

	@When("trader inserts stock <symbol> with threshold <threshold> and trade at <tradeAt>")
	public void newStockDataIsProvided(@Named("symbol")String symbol, @Named("threshold")String threshold, @Named("tradeAt")String tradeAt) {
		insertStockPage.fillForm(symbol, threshold, tradeAt);
		insertStockPage.submitForm();
	}

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        insertStockPage.fillFeedback("myName", "anotherPerson", "Yay!");
        insertStockPage.submitForm();
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        assertThat(insertStockPage.viewFeedback("feedback_1"), containsString("Yay!"));
    }

	@Then("web page should show an <status> message")
	public void stockStatusShouldBeShowed(@Named("status")StockAlertStatus status) {
		assertThat(showStockStatusPage.getStockStatusMessage(), is(status.name()));
	}
}
