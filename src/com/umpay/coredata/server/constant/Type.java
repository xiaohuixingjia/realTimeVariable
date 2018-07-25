package com.umpay.coredata.server.constant;

public enum Type {	
	 other("0"),
	 trade("1"),
	 bill("2"),
	 overdue("3"),
	 reject("4"),
	 status("5"),
	 limit("6"),
	 period("7"),
	 birthday("8"),
	 name("21"),
	 card("22"),
	 region("23"),
	 bank("31"),
	 marketing("32"),
	 mobile("33"),
	 site("34"),
	 fund("35"),
	 debitIn("41"),
	 debitOut("42"),
	 creditIn("43"),
	 creditOut("44"),
	 unnormalDate("97"),
	 unnormalTrade("98"),
	 error("99");
	
	 Type(String str){
		 this.value = str;
	 }
	 
	 @Override
	public String toString() {
		return this.value;
	}
	 
	 public String value;
}

