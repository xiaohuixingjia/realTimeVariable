package com.umpay.coredata.server.variables.impl;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
/**
 * 通用的笔数计算类
 * @author xuxiaojia
 * 2018年3月26日
 */
public class AmountCntCountVariable<T> extends AbsVariable<T>{
	private Long l=0l;
	public AmountCntCountVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public AmountCntCountVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}
	@Override
	protected void childMerge(T p) {
		l++;
 	}

	@Override
	public void clear() {
		l = 0l;
	}

	@Override
	protected String getV() throws Exception {
		if(l==0){
			return null;
		}
		return String.valueOf(l);
	}

}
