package com.umpay.ruleTimeVariable.bean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.umpay.ruleTimeVariable.util.ListUtil;


/**
 * 多头表明细的模型类
 * @author wangwei
 * 成员变量的字典注释仅为了方便查看，最终以文档为准，请时刻保持同步
 */
public class MultiHeadPo implements AbstractDataPo,Comparable<MultiHeadPo>{
	public static Map<String,Integer> fieldMapping = null; 
	private List<String> dataArray = new ArrayList<String>();
	 
	static {
		fieldMapping = new HashMap<String,Integer>();
		fieldMapping.put("mobile",0);
		fieldMapping.put("date",1);
		fieldMapping.put("mertId",2);
		fieldMapping.put("mertType",3);
		fieldMapping.put("dataType",4);
		fieldMapping.put("borrowCnt",5);
	}
	
	public void setDataArray(List<String> dataArray) {
		this.dataArray = dataArray;
	}
	
	public String getMobile() {
		return ListUtil.getWithOutException(dataArray,0);
	}
	
	@Override
	public String getDate() {
		return ListUtil.getWithOutException(dataArray,1);
	}
	
	public String getMertId() {
		return ListUtil.getWithOutException(dataArray,2);
	}
	
	public List<String> getDataArray() {
		return dataArray;
	}

	public String getMertType() {
		return ListUtil.getWithOutException(dataArray,3);
	}
	
	public String getDataType() {
		return ListUtil.getWithOutException(dataArray,4);
	}
	
	public String getBorrowCnt() {
		return ListUtil.getWithOutException(dataArray,5);
	}

	@Override
	public int compareTo(MultiHeadPo o) {
		return Integer.parseInt(this.getDate()) - Integer.parseInt(o.getDate());  
	}
}
