package com.umpay.coredata.server.conditions.impl;

import com.umpay.coredata.server.conditions.AbsCondition;
import com.umpay.coredata.server.conditions.Condition;
public class RangeCondition extends AbsCondition implements Condition{

	private int[] min; //数组中包含两个元素,第一个元素为条件最小值,第二个元素表示区间是否闭合(0表示开区间,1表示表示闭区间)
	
	private int[] max; //数组中包含两个元素,第一个元素为条件最大值,第二个元素表示区间是否闭合(0表示开区间,1表示表示闭区间)
	
	
	@Override
	public boolean execute(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public int[] getMin() {
		return min;
	}


	public void setMin(int[] min) {
		this.min = min;
	}


	public int[] getMax() {
		return max;
	}


	public void setMax(int[] max) {
		this.max = max;
	}
}
