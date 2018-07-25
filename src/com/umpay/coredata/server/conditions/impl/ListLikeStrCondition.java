package com.umpay.coredata.server.conditions.impl;

import java.util.List;

import com.umpay.coredata.server.conditions.AbsCondition;
import com.umpay.coredata.server.conditions.Condition;
import com.umpay.ruleTimeVariable.util.ClassUtil;
/**
 * 判断元素属性是否包含集合中的某个数据
 * 
 * @author xuxiaojia
 */
public class ListLikeStrCondition extends AbsCondition implements Condition {
	/*
	 * 包含的元素信息
	 */
	private List<String> likeValues;
	/*
	 * 元素属性名
	 */
	private String elemName;

	public ListLikeStrCondition(String elemName,List<String> likeValues) {
		super();
		this.likeValues = likeValues;
		this.elemName = elemName;
	}

	@Override
	public boolean execute(Object obj) {
		try {
			Object fv = ClassUtil.getClassUtil().getFieldValeWithException(elemName, obj);
			if (fv == null) {
				return false;
			}
			for (String s : likeValues) {
				if (String.valueOf(fv).contains(s)) {
					return true;
				}
			}
		} catch (Exception e) {
			_log.error("相等条件判断出现异常,条件值:" + likeValues.toString() + ",元素属性名:" + elemName + ",输入元素:" + obj.toString(), e);
		}
		return false;
	}
}
