package com.umpay.coredata.server.Factory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.umpay.coredata.server.conditions.Condition;
import com.umpay.coredata.server.conditions.impl.AndConditions;
import com.umpay.coredata.server.conditions.impl.EquailsCondition;
import com.umpay.coredata.server.conditions.impl.IsnotBlankCondition;
import com.umpay.coredata.server.conditions.impl.ListLikeStrCondition;
import com.umpay.coredata.server.conditions.impl.TrueCondition;


public class ConditionFactory {
	private static final Map<String, Condition> CONDITION_MAP=new HashMap<String, Condition>();
	public static Condition getCD(String conditionStr) {
		Condition condition = null;
		
		//绝对真条件
		if("true".equals(conditionStr)){
			Condition trueCondition = new TrueCondition();
			return trueCondition;
		}
		
		if(CONDITION_MAP.containsKey(conditionStr)){
			return CONDITION_MAP.get(conditionStr);
		}
		//如果and子语句里面包以括号包住的子逻辑
		//逻辑或条件
		if(conditionStr.startsWith("(") && conditionStr.contains("or")){
			conditionStr = conditionStr.substring(1,conditionStr.length()-1);
			String[] cds = conditionStr.split(" or ");
			return getCondition(cds);
		}
		//逻辑与条件
		if (conditionStr.indexOf(" and ") != -1) {
			List<Condition> andConStr = new ArrayList<Condition>();
			String[] cds = conditionStr.split(" and ");
			for (String string : cds) {
				andConStr.add(getCD(string.trim()));
			}
			condition = new AndConditions(andConStr);
		}
		//非空条件
		else if(conditionStr.indexOf("!=null") != -1){
			String[] split = conditionStr.split("!=");
			condition=new IsnotBlankCondition(split[0].trim());
		}
		//equal条件
		else if (conditionStr.indexOf("=") != -1) {
			String[] split = conditionStr.split("=");
			condition = new EquailsCondition(split[0].trim(), split[1].trim());
		}
		//like条件
		else if (conditionStr.indexOf("like") != 1) {
			String[] split = conditionStr.split("like");
			condition = new ListLikeStrCondition(split[0].trim(),Arrays.asList(split[1].trim().split(",")));
		} 
//		else if(conditionStr.indexOf("(") != -1 ||
//				      conditionStr.indexOf("[") != -1 || 
//				      conditionStr.indexOf(")") != -1 || 
//				      conditionStr.indexOf("]") != -1){
//			condition = new RangeCondition();
//		}
		CONDITION_MAP.put(conditionStr, condition);
		return condition;
	}
	
	/**
	 * 组装有关联关系的condition
	 * @param conditionStr 条件表达式
	 * @author pangwei
	 */
	public static Condition getCondition(String[] conditions){
		Condition c = null;
		Condition first = null;
		for(String condition : conditions){
			if(condition.contains("=")){
				String[] split = condition.split("=");
				if(c == null){
					c = new EquailsCondition(split[0].trim(), split[1].trim());
					first=c;
				}else{
					Condition n = new EquailsCondition(split[0].trim(), split[1].trim());
					c.setNextCondition(n);
					c=n;
				}
			}else if(condition.contains("like")){
				String[] split = condition.split("like");
				if(c == null){
					c = new ListLikeStrCondition(split[0].trim(),Arrays.asList(split[1].trim().split(",")));
					first=c;
				}else{
					Condition n = new ListLikeStrCondition(split[0].trim(),Arrays.asList(split[1].trim().split(",")));
					c.setNextCondition(n);
					c=n;
				}
			}
		}
		return first;
	}
}

