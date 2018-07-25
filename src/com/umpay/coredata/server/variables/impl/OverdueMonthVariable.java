package com.umpay.coredata.server.variables.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 逾期银行变量判断
 * 
 * @author xuxiaojia 2018年3月26日
 */
public class OverdueMonthVariable extends AbsVariable<DetailPo> {

	public OverdueMonthVariable(int index, String conditionStr, String mergeElems, String ranges) {
		this.index = index;
		this.condition = ConditionFactory.getCD(conditionStr);
		// String[] split = mergeElems.split(";");
		// this.mergeElems =
		// mergeElems==null?null:Arrays.asList(split[0].split(","));
		this.mergeElems = mergeElems == null ? null : Arrays.asList(mergeElems.split(","));
		this.pretreatmet = Pretreatmet.DoNothingPretreatmet;
		String[] rangess = ranges.split(",");

		min[0] = Integer.parseInt(rangess[0].substring(1));
		if (rangess[0].startsWith("[")) {
			min[1] = 0;
		} else {
			min[1] = 1;
		}
		max[0] = Integer.parseInt(rangess[1].substring(0, rangess[1].length() - 1));

		if (rangess[1].endsWith("]")) {
			max[1] = 0;
		} else{
			max[1] = 1;
		}

	}

	public OverdueMonthVariable(int index, String conditionStr, String mergeElems, String ranges,
			Pretreatmet pretreatmet) {
		this(index, conditionStr, mergeElems, ranges);
		this.pretreatmet = pretreatmet;
	}

	private int[] min = new int[2];
	private int[] max = new int[2];

	private Map<String, Long> map = new HashMap<String, Long>();
	private  int has = 4; //存在为1 不存在为0 3为空 默认为4

	@Override
	protected void childMerge(DetailPo p) {
		// 取配置里的最后一个字段当做值
		long value = Math
				.abs(Double
						.valueOf(ClassUtil.getClassUtil()
								.getFieldValeNoException(mergeElems.get(mergeElems.size() - 1), p).toString())
				.longValue());
		if(has==1){
			return;
		}
		
		if (max[0] < 0) {
			// 左闭区间
			if (min[1] == 0 && value >= min[0]) {
				has = 1;
				return;
			} else if (min[1] == 0 && value >= min[0]) {
				has = 1;
				return ;
			}
		}

		// 左闭区间
		if (min[1] == 0) {
			// 左闭右闭区间
			if (max[1] == 0 && value <= max[0] && value >= min[0]) {
				has = 1;
			} else {
				// 左闭右开区间
				if (value < max[0] && value >= min[0]) {
					has = 1;
				}else{
					if("".equals(ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(mergeElems.size() - 1), p).toString())){
						has = 3;
					}else{
						has = 0;
					}
				}
			}
		}
		// 左开区间
		else {
			//正无穷范围
			if (max[0] < 0) {
				// 左闭区间
				if (min[1] == 0 && value >= min[0]) {
					has = 1;
					return;
				} else if (min[1] == 1 && value > min[0]) {
					has = 1;
					return ;
				}else{
					has = 0;
				}
			}
			
			// 左开右闭区间
			if (max[1] == 0 && value <= max[0] && value > min[0]) {
				has = 1;
			} else {
				// 左开右开区间
				if (value < max[0] && value > min[0]) {
					has = 1;
				}else{
					if("".equals(ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(mergeElems.size() - 1), p).toString())){
						has = 3;
					}else{
						has = 0;
					}
				}
			}
		}
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	protected String getV() throws Exception {
		if(has == 0 || has == 1){
			return String.valueOf(has);
		}else if(has == 3){
			return "";
		}
		return null;
	}
}
