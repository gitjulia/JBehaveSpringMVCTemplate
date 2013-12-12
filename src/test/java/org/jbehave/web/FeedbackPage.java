package org.jbehave.web;

import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackPage {

	private static final String SENDER_FORM_ID = "sender";
	private static final String RECIPIENT_FORM_ID = "recipient";
	private static final String RECIPIENT_SEARCH_FORM_ID = "recipientSearchFormId";
	private static final String FEEDBACK_FORM_ID = "feedback";
	private static final String SUBMIT_FEEDBACK_FORM_ID = "submitFeedbackButton";
	private static final String SUBMIT_RECIPIENT_FORM_ID = "submitRecipientButton";

	private String stockUrl;
	@Autowired
	private PageUtils pageUtils;
	
	public void open() {
		pageUtils.open(this.stockUrl);
	}

    public void close() {
        pageUtils.close();
    }
	
	public void submitFeedbackForm() {
//		pageUtils.submitForm(SUBMIT_FEEDBACK_FORM_ID);
        pageUtils.clickButton(SUBMIT_FEEDBACK_FORM_ID);
	}
	
	public void setStockUrl(String url) {
		this.stockUrl = url;
	}

    public void fillFeedback(String name, String recipient, String feedback) {
        pageUtils.fillFormField(SENDER_FORM_ID, name);
        pageUtils.fillFormField(RECIPIENT_FORM_ID, recipient);
        pageUtils.fillFormField(FEEDBACK_FORM_ID, feedback);
    }

    public String viewFeedback(String feedbackId) {
        return pageUtils.getElementText(feedbackId);
    }

    public String viewRecipient(String recipientId) {
        return pageUtils.getElementText(recipientId);
    }

    public String viewSender(String senderId) {
        return pageUtils.getElementText(senderId);
    }


    public void fillSearchFeedbackForm(String recipient) {
        pageUtils.fillFormField(RECIPIENT_SEARCH_FORM_ID, recipient);
    }

    public void submitSearchFeedbackForm() {
        pageUtils.clickButton(SUBMIT_RECIPIENT_FORM_ID);
    }
}
