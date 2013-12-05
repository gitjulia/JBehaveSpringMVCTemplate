package org.jbehave.web;

public class FeedbackForm {

	private String name;
	private String recipient;
	private String feedback;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

	public String getRecipient() {
		return recipient;
	}

    public void setFeedback(String feedback){
        this.feedback = feedback;
    }

	public String getFeedback() {
		return feedback;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackForm other = (FeedbackForm) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
