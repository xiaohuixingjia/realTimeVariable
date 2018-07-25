package com.umpay.coredata.server.constant;

public enum DateMergeType {

	year(1),
	month(2),
	day(3);
	
	DateMergeType(int value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return new Integer(this.value).toString();
	}
	
	public int value;
}
