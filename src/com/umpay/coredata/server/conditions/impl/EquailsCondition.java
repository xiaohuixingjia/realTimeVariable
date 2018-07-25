package com.umpay.coredata.server.conditions.impl;

import com.umpay.coredata.server.conditions.AbsCondition;
import com.umpay.coredata.server.conditions.Condition;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 相等条件判断
 * 
 * @author xuxiaojia
 */
public class EquailsCondition extends AbsCondition implements Condition {
	/*
	 * 条件值
	 */
	private String eqValue;
	/*
	 * 元素属性名
	 */
	private String elemName;

	public EquailsCondition(String elemName,String eqValue) {
		super();
		this.eqValue = eqValue;
		this.elemName = elemName;
	}

	@Override
	public boolean execute(Object obj) {
		try {
			return eqValue.equals(ClassUtil.getClassUtil().getFieldValeWithException(elemName, obj).toString().trim());
		} catch (Exception e) {
			_log.error("相等条件判断出现异常,条件值:" + eqValue + ",元素属性名:" + elemName + ",输入元素:" + obj.toString(), e);
		}
		return false;
	}
	

}
