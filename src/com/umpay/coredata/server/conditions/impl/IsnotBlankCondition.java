package com.umpay.coredata.server.conditions.impl;

import org.apache.commons.lang.StringUtils;

import com.umpay.coredata.server.conditions.AbsCondition;
import com.umpay.coredata.server.conditions.Condition;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 非空条件
 * @author pangwei
 *
 */
public class IsnotBlankCondition extends AbsCondition implements Condition{

	
	private String elemName;

	public IsnotBlankCondition(String elemName) {
		super();
		this.elemName = elemName;
	}
	
	
	@Override
	public boolean execute(Object obj) {
		
		try {
			String value = ClassUtil.getClassUtil().getFieldValeWithException(elemName, obj).toString().trim();
			if(!StringUtils.isEmpty(value)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
