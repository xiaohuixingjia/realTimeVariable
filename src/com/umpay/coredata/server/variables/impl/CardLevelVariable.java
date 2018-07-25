package com.umpay.coredata.server.variables.impl;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;
/**
 * 最大卡等级实现类 
 * @author pangwei
 *
 */
public class CardLevelVariable extends AbsVariable<DetailPo>{

	private int level;
	
	
	
	public CardLevelVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public CardLevelVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}
	
	
	@Override
	public void clear() {
		level = 0;
	}

	@Override
	protected void childMerge(DetailPo t) {
		String value = ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(0), t).toString();
		int result = getCardLevel(value);
		if(level < result){
			level = result;
		}
	}

	@Override
	protected String getV() throws Exception {
		return String.valueOf(level);
	}
	
	
	/**
	 * 根据卡名称获取卡等级
	 * @param cardName
	 * @return
	 */
	private int getCardLevel(String cardName){
		if(cardName.contains("VIP") || cardName.contains("vip")){
			return 5;
		}else if(cardName.contains("白金")){
			return 3;
		}else if(cardName.contains("金")){
			return 2;
		}else if(cardName.contains("钻石")){
			return 4;
		}else{
			return 1;
		}
	}
}
