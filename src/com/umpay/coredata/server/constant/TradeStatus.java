package com.umpay.coredata.server.constant;


public enum TradeStatus {
	 normal("0"),
	 fail("f"),
	 sms("s"),
	 notify("n"),
	 other("o"),
	 plan("p");
	
	TradeStatus(String value){
	 this.value = value;
	}
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
