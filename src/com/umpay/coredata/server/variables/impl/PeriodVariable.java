package com.umpay.coredata.server.variables.impl;

import java.util.HashSet;
import java.util.Set;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

/**
 * 近一年分期数
 * @author pangwei
 *
 */
public class PeriodVariable extends AbsVariable<DetailPo>{

	
	private Set<String> set = new HashSet<String>();
	
	
	public PeriodVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		this.index = index;
		this.condition = ConditionFactory.getCD(conditionStr);
		if(pretreatmet!=null){
			this.pretreatmet = pretreatmet;
		}
	}
	
	
	@Override
	public void clear() {
		set.clear();
	}

	@Override
	protected void childMerge(DetailPo t) {
		set.add(t.getBank() + "_" + t.getCardNo());
	}

	@Override
	protected String getV() throws Exception {
		if(set.size() > 0){
			return String.valueOf(set.size());
		}else{
			return null;
		}
	}
}
