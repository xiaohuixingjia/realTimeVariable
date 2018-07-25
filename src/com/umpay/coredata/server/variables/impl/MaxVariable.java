package com.umpay.coredata.server.variables.impl;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 通用的最大值计算类
 * 
 * @author xuxiaojia 2018年3月26日
 */
public class MaxVariable<T> extends AbsVariable<T> {
	public MaxVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public MaxVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}

	private Long l;

	@Override
	protected void childMerge(T p) {
		Long v = Math
				.abs(Double.valueOf(ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(0), p).toString()).longValue());
		if (l == null) {
			l = v;
		} else if (l < v) {
			l = v;
		}
	}

	@Override
	public void clear() {
		l = null;
	}

	@Override
	protected String getV() throws Exception {
		if (l == null) {
			return null;
		}
		return String.valueOf(l);
	}
}
