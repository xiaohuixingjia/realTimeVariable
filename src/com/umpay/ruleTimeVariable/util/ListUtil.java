package com.umpay.ruleTimeVariable.util;

import java.util.List;

public class ListUtil {
	public static String getWithOutException(List<String> list,int index){
		if(list == null || list.size()<=index)return "";
		return list.get(index);
	}
	
	public static boolean setWithOutException(List<String> list,int index,String s){
		if(list == null || list.size()<=index)return false;
		list.set(index, s);
		return true;
	}	
}
