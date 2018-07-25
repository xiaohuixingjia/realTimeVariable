package com.umpay.coredata.server.conditions.impl;

import com.umpay.coredata.server.conditions.AbsCondition;
import com.umpay.coredata.server.conditions.Condition;

/**
 * 该条件永远返回true
 * @author pangwei
 *
 */
public class TrueCondition extends AbsCondition implements Condition{

	@Override
	public boolean execute(Object obj) {
		return true;
	}
}
