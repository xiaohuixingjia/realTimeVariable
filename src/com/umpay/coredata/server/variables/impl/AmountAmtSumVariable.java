package com.umpay.coredata.server.variables.impl;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 通用的金额计算类
 * @author xuxiaojia
 * 2018年3月26日
 */
public class AmountAmtSumVariable<T> extends AbsVariable<T>{
	public AmountAmtSumVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public AmountAmtSumVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}

	private Long l;

	@Override
	protected void childMerge(T p) {
		if(l==null){
			l=0l;
		}
		l+=Math.abs(Double.valueOf(ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(0), p).toString()).longValue());
	}

	@Override
	public void clear() {
		l = null;
	}

	@Override
	protected String getV() throws Exception {
		if(l==null){
			return null;
		}
		return String.valueOf(l);
	}

}
