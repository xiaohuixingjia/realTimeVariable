package com.umpay.coredata.server.variables;

/**
 * 变量的接口定义
 * 
 * @author xuxiaojia 2018年3月25日
 */
public interface VariableI<T> {
	/**
	 * 获取当前变量的结果
	 * 
	 * @return
	 */
	public String get();

	/**
	 * 合并
	 */
	public void merge(T t);

	/**
	 * 清空所有属性
	 */
	public void clear();
	
}