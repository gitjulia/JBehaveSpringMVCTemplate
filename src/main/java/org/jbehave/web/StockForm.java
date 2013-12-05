package org.jbehave.web;

public class StockForm {

	private String name;
	private String threshold;
	private String tradeAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void setThreshold(String threshold){
        this.threshold = threshold;
    }

	public String getThreshold() {
		return threshold;
	}

    public void setTradeAt(String tradeAt){
        this.tradeAt = tradeAt;
    }

	public String getTradeAt() {
		return tradeAt;
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
		StockForm other = (StockForm) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
