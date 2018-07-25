package com.umpay.coredata.server.conditions.impl;

import java.util.List;

import com.umpay.coredata.server.conditions.Condition;
import com.umpay.coredata.server.conditions.ListCondition;


public class AndConditions extends ListCondition {

	public AndConditions(List<Condition> conditions) {
		super(conditions);
	}

	@Override
	/**
	 * 所有条件成立则返回true
	 */
	public boolean execute(Object obj) {
		for (Condition condition : conditions) {
			
			if(!condition.execute(obj) && condition.getNextCondition() == null){
				return false;
			}
			
			//用来匹配表达式中(A or B)的关系,这种关系是由一个condition链组成的
			//以下判断会沿着condition链依次进行验证,链上condition之间都是或的关系
			//因此只要有一个condition满足匹配即返回true,因此表达式中(A or B)这种关系
			//暂时只能写在最后如:type=1 and (b=1 or b=1)
			
			if(condition.getNextCondition() != null){
				return getOrConditionResult(condition,obj);
			}
			
		}
		return true;
	}
	
	private boolean getOrConditionResult(Condition condition,Object obj){
		boolean flag = false;
		do{
			if(condition.execute(obj) == true){
				return true;
			}
		}while((condition=condition.getNextCondition())!=null);
		return flag;
	}
}
