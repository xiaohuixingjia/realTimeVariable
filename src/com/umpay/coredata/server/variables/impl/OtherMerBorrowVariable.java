package com.umpay.coredata.server.variables.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.MultiHeadPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;

public class OtherMerBorrowVariable extends AbsVariable<MultiHeadPo>{
private Set<String> bankSet = new HashSet<String>(); 
	
	
	public OtherMerBorrowVariable(int index,String conditionStr,String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public OtherMerBorrowVariable(int index,String conditionStr,String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}
	
	
	@Override
	public void clear() {
		bankSet.clear();
	}

	@Override
	protected void childMerge(MultiHeadPo p) {
		//去掉重复的bank
		if(!"1".equals(p.getMertType()) && !"4".equals(p.getMertType()) && !"8".equals(p.getMertType())){
			bankSet.add(ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(0), p).toString());
		}
	}
	
	@Override
	protected String getV() throws Exception {
		if(CollectionUtils.isEmpty(bankSet)){
			return null;
		}
		return Integer.toString(bankSet.size());
	}
}
