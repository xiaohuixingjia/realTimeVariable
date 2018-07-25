package com.umpay.coredata.server.variables.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

/**
 * 信用卡总额度
 * @author pangwei
 *
 */
public class CreditcardAllVariable extends AbsVariable<DetailPo>{

	private Map<String,Long> map = new HashMap<String,Long>();
	
	
	public CreditcardAllVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public CreditcardAllVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}
	
	
	@Override
	public void clear() {
		map.clear();
	}

	@Override
	protected void childMerge(DetailPo t) {
		String key = t.getBank() + "_" + t.getCardNo();
		if(map.containsKey(key)){
			Long value = map.get(key);
			if(Long.valueOf(t.getA()) > value){
				map.put(key,Long.valueOf(t.getA()));
			}
		}else{
			map.put(key,Long.valueOf(t.getA()));
		}
	}

	@Override
	protected String getV() throws Exception {
		long l = 0l;
		if(map.size() > 0){
			for(Entry<String,Long> entry : map.entrySet()){
				l+=entry.getValue();
			}
		}else{
			return null;
		}
		return String.valueOf(l);
	}
}
