package com.umpay.coredata.server.variables.impl;


import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

public class SpecialVariable extends AbsVariable<DetailPo>{

	public SpecialVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		this.index = index;
		this.condition = ConditionFactory.getCD(conditionStr);
		if(pretreatmet!=null){
			this.pretreatmet = pretreatmet;
		}
	}
	
	
	private long l;
	
	@Override
	public void clear() {
		l=0l;
	}

	@Override
	protected void childMerge(DetailPo t) {
		if(t.getC().length() >= t.getA().length()){
			l += Long.valueOf(t.getC());
		}else{
			l += Long.valueOf(t.getA());
		}
	}

	@Override
	protected String getV() throws Exception {
		return String.valueOf(l);
	}
}
