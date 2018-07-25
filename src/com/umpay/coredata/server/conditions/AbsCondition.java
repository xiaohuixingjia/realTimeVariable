package com.umpay.coredata.server.conditions;

public abstract class AbsCondition implements Condition{
	protected Condition nextCondition = null;
	
	@Override
	public void setNextCondition(Condition condition) {
		this.nextCondition = condition;
	}
	
	@Override
	public Condition getNextCondition() {
		return this.nextCondition;
	}
}
