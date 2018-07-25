package com.umpay.coredata.server.constant;

public enum DateMergeLimit {
	first(0),
	lastest(1);
	
	DateMergeLimit(int value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return new Integer(this.value).toString();
	}
	
	public int value;
}