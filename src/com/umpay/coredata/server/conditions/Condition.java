package com.umpay.coredata.server.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 条件
 * 
 * @author xuxiaojia
 */
public interface Condition {
	final static Logger _log = LoggerFactory.getLogger("Condition");

	/**
	 * 根据输入信息判断条件是否成立
	 * 
	 * @param obj
	 * @return
	 */
	public boolean execute(Object obj);
	
	/**
	 * 设置下一个condition,以此关系设置的condition之间都是或的关系
	 */
	public void setNextCondition(Condition condition);
	
	/**
	 * 获取下一个condition
	 */
	public Condition getNextCondition();
	
	
}
