package com.umpay.coredata.server.variables.impl;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;
/**
 * 
 * @author xuxiaojia 2018年3月26日
 */
public class MaxVariableWithM extends AbsVariable<DetailPo> {
	public MaxVariableWithM(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public MaxVariableWithM(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}

	private Long l;

	@Override
	protected void childMerge(DetailPo p) {
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
		return Mfilter(l);
	}
	
	//TODO:此处应该选择一个合理的方式，在表达式上做改动，判断是否经过这个方法的处理
	private String Mfilter(long l){
		if(l>0 && l<=30){
			return "M1";
		}else if(l>30 && l<=60){
			return "M2";
		}else if(l>60 && l<=90){
			return "M3";
		}else{
			return "M3+";
		}
	}

}
