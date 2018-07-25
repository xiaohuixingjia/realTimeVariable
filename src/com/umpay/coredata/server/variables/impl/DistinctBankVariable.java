package com.umpay.coredata.server.variables.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

/**
 * 统计银行个数
 * @author pangwei 2018年4月3日
 *
 */
public class DistinctBankVariable<T> extends AbsVariable<T>{

	private Set<String> bankSet = new HashSet<String>(); 
	
	
	public DistinctBankVariable(int index,String conditionStr,String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public DistinctBankVariable(int index,String conditionStr,String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}
	
	
	@Override
	public void clear() {
		bankSet.clear();
	}

	@Override
	protected void childMerge(T p) {
		if("4".equals(((DetailPo)p).getBank()) && "9517".equals(((DetailPo)p).getCardNo())){
			System.out.println("asdsad");
		}
		
		
		//去掉重复的bank
		bankSet.add(((DetailPo)p).getBank() + "_" + ((DetailPo)p).getCardNo());
	}
	
	@Override
	protected String getV() throws Exception {
		if(CollectionUtils.isEmpty(bankSet)){
			return null;
		}
		return Integer.toString(bankSet.size());
	}
}
