package com.umpay.coredata.server.constant;

public enum Card {
	unknown("0"), 
	debit("1"), // 储蓄卡
	credit("2"); // 信用卡 un

	Card(String value){
		this.value = value;
	}
	
	public String value;
	
	@Override
	public String toString() {
		return this.value;
	}
}
