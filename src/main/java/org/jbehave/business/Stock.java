package org.jbehave.business;

public class Stock {

	private String threshold = "0";
	private String trade = "0";
	
	public Stock(String threshold) {
		this.threshold = threshold;
	}
	
	public void setTradeAt(String tradeAt) {
		this.trade = tradeAt;
	}
	
	public StockAlertStatus getStatus() {
		return StockAlertStatus.OFF;
	}
	
}
