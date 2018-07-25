package com.umpay.coredata.server.conditions;


import java.util.List;

/**
 * 多个判断条件组成的条件
 * 
 * @author xuxiaojia
 */
public abstract class ListCondition extends AbsCondition implements Condition {
	/**
	 * 多个判断条件组成的集合
	 */
	protected List<Condition> conditions;

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public ListCondition(List<Condition> conditions) {
		super();
		this.conditions = conditions;
	}
}
