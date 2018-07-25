package com.umpay.coredata.server.variables.impl;

import org.apache.commons.lang.StringUtils;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

/**
 * 信用卡,分期,增额,消费,贷款被拒次数
 * @author pangwei
 *
 */
public class RefuseVariable extends AbsVariable<DetailPo>{

	private Long l = null;
	private String value;
	
	
	public RefuseVariable(int index, String conditionStr, String mergeElems) {
		this.index = index;
		this.condition = ConditionFactory.getCD("true");
		this.pretreatmet = Pretreatmet.DoNothingPretreatmet;
		if(!StringUtils.isEmpty(conditionStr)){
			value = conditionStr.split("and")[1].trim().split("=")[1];
		}
	}
	
	
	@Override
	public void clear() {
		l = null;
	}

	@Override
	protected void childMerge(DetailPo t) {
		if("4".equals(t.getType())){
			if(l == null){
				l = 0l;
			}
			if(value.equals(t.getA())){
				l++;
			}
		}
	}

	@Override
	protected String getV() throws Exception {
		if(l == null){
			return "";
		}else{
			return String.valueOf(l);
		}
	}

}
