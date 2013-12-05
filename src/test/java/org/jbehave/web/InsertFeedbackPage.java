package org.jbehave.web;

import org.springframework.beans.factory.annotation.Autowired;

public class InsertFeedbackPage {

	private static final String NAME_FORM_ID = "name";
	private static final String RECIPIENT_FORM_ID = "recipient";
	private static final String FEEDBACK_FORM_ID = "feedback";
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
	
	public void submitForm() {
		pageUtils.submitForm(SUBMIT_FORM_ID);		
	}
	
	public void setStockUrl(String url) {
		this.stockUrl = url;
	}

    public void fillFeedback(String name, String recipient, String feedback) {
        pageUtils.fillFormField(NAME_FORM_ID, name);
        pageUtils.fillFormField(RECIPIENT_FORM_ID, recipient);
        pageUtils.fillFormField(FEEDBACK_FORM_ID, feedback);
    }

    public String viewFeedback(String feedback_id) {
        return pageUtils.getElementText(feedback_id);
    }

    public String viewRecipient(String recipient_id) {
        return pageUtils.getElementText(recipient_id);
    }
}
