package org.jbehave.web;

import org.springframework.beans.factory.annotation.Autowired;

public class InsertStockPage {

	private static final String STOCK_FORM_ID = "name";
	private static final String THRESHOLD_FORM_ID = "threshold";
	private static final String TRADEAT_FORM_ID = "tradeAt";
	private static final String SUBMIT_FORM_ID = "submit";
	
	private String stockUrl;
	@Autowired
	private PageUtils pageUtils;
	
	public void open() {
		pageUtils.open(this.stockUrl);
	}

    public void close() {
        pageUtils.close();
    }
	
	public void fillForm(String stockName, String threshold, String tradeAt) {
		pageUtils.fillFormField(STOCK_FORM_ID, stockName);
		pageUtils.fillFormField(THRESHOLD_FORM_ID, threshold);
		pageUtils.fillFormField(TRADEAT_FORM_ID, tradeAt);
	}
	
	public void submitForm() {
		pageUtils.submitForm(SUBMIT_FORM_ID);		
	}
	
	public void setStockUrl(String url) {
		this.stockUrl = url;
	}

    public void fillFeedback(String name, String recipient, String feedback) {
        pageUtils.fillFormField(STOCK_FORM_ID, name);
        pageUtils.fillFormField(THRESHOLD_FORM_ID, recipient);
        pageUtils.fillFormField(TRADEAT_FORM_ID, feedback);
    }

    public String viewFeedback(String feedback_id) {
        return pageUtils.getElementText(feedback_id);
    }

    public String viewRecipient(String recipient_id) {
        return pageUtils.getElementText(recipient_id);
    }
}
