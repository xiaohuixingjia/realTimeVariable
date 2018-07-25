package com.umpay.coredata.server.variables.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.constant.DateMergeLimit;
import com.umpay.coredata.server.constant.DateMergeType;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;


public class DateVariable extends AbsVariable<DetailPo>{
	
	public DateVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		this.index = index;
		this.condition = ConditionFactory.getCD(conditionStr);
		this.pretreatmet = Pretreatmet.DoNothingPretreatmet;
		
		String extraInfo = mergeElems.substring(mergeElems.indexOf("["),mergeElems.lastIndexOf("]")+1);
		mergeElems = mergeElems.substring(0,mergeElems.indexOf("["));
		this.mergeElems = mergeElems==null?null:Arrays.asList(mergeElems.split(","));
		parseExtraInfo(extraInfo);
		
		if(pretreatmet!=null){
			this.pretreatmet = pretreatmet; 
		}
	}
	
	public List<DateMergeType> mergeTypes = new ArrayList<DateMergeType>();
	public DateMergeLimit mergeLimit;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private long l;
	
	@Override
	public void clear() {
		l = 0l;
	}

	@Override
	protected void childMerge(DetailPo t) {
		String value = ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(0), t).toString();
		try {
			Date date = sdf.parse(value);
			if(l == 0l){
				l = date.getTime();
			}else{
				if(mergeLimit.equals(DateMergeLimit.first) && date.getTime() < l){
					l = date.getTime();
					
				}else if(mergeLimit.equals(DateMergeLimit.lastest) && date.getTime() > l){
					l = date.getTime();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getV() throws Exception {
		if(l == 0l){
			return "";
		}
		Date date =new Date(l);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		StringBuffer result = new StringBuffer();
		
		for(DateMergeType type : mergeTypes){
			if(type.equals(DateMergeType.month)){
				if(calendar.get(Calendar.MONTH)+1 < 10){
					result.append(0);
				}
				result.append(calendar.get(Calendar.MONTH)+1);
			}else if(type.equals(DateMergeType.day)){
				if(calendar.get(Calendar.DAY_OF_MONTH) < 10){
					result.append(0);
				}
				result.append(calendar.get(Calendar.DAY_OF_MONTH));
			}else if(type.equals(DateMergeType.year)){
				result.append(calendar.get(Calendar.YEAR));
			}
		}
		return result.toString();
	}
	
	private void parseExtraInfo(String extraInfo){
		String[] extraInfos = extraInfo.substring(1,extraInfo.length()-1).split(":");
		String[] dateInfos = extraInfos[0].split(",");
		for(String dateInfo : dateInfos){
			if("month".equals(dateInfo)){
				mergeTypes.add(DateMergeType.month);
			}else if("year".equals(dateInfo)){
				mergeTypes.add(DateMergeType.year);
			}else{
				mergeTypes.add(DateMergeType.day);
			}
		}
		
		
		
		
		if("first".equals(extraInfos[1])){
			mergeLimit = DateMergeLimit.first;
		}else{
			mergeLimit = DateMergeLimit.lastest;
		}
	}
}
