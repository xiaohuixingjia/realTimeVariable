package com.umpay.coredata.server.variables;


import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.conditions.Condition;
import com.umpay.coredata.server.constant.VariableConstant;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;


/**
 * 变量接口的抽象实现
 * 
 * @author xuxiaojia 2018年3月25日
 * @param <T>
 */
public abstract class AbsVariable<T> implements VariableI<T> {
	private static Logger log = LoggerFactory.getLogger("AbsVariable");

	public AbsVariable() {

	}

	public AbsVariable(int index, Condition condition, String mergeElems) {
		this(index, condition, mergeElems, Pretreatmet.DoNothingPretreatmet);
	}

	public AbsVariable(int index, Condition condition, String mergeElems, Pretreatmet pretreatmet) {
		super();
		this.index = index;
		this.condition = condition;
		this.mergeElems = mergeElems == null ? null : Arrays.asList(mergeElems.split(","));
		this.pretreatmet = pretreatmet;
	}

	/**
	 * 空的变量信息
	 */
	public static final String EMPTY_VARIABLE = "";
	/**
	 * 该变量的下标
	 */
	protected int index;
	/**
	 * 判断条件
	 */
	protected Condition condition;
	/**
	 * 聚合的元素
	 */
	protected List<String> mergeElems;
	/**
	 * 预处理
	 */
	protected Pretreatmet pretreatmet;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<String> getMergeElems() {
		return mergeElems;
	}

	public void setMergeElems(List<String> mergeElems) {
		this.mergeElems = mergeElems;
	}

	@Override
	public String get() {
		try {
			String v;
			v = getV();
			if (StringUtils.isNotEmpty(v)) {
				return v;
			}
		} catch (Exception e) {
			log.error("当前下标位" + getIndex() + "变量名" + VariableConstant.INDEX_DESC.get(getIndex()) + "取值异常", e);
		}
		return EMPTY_VARIABLE;
	}

	/**
	 * 通用的父类实现 先判断是否符合逻辑，不符合则略过
	 */
	@Override
	public void merge(T t) {
		//执行预处理，如果预处理出错或者返回为null 则直接略过
		if (t instanceof DetailPo) {
			try {
				Object o = pretreatmet.excute((DetailPo) t);
				if (o != null) {
					o = (T) t;
				}else{
					return ;
				}
			} catch (Exception e) {
//				e.printStackTrace();
				return ;
			}
		}
		if (condition.execute(t)) {
			try {
				childMerge(t);
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
	}

	/**
	 * 通用的验证要聚合的值是否正常
	 * 
	 * @param t
	 * @return
	 */
	protected boolean checkElemVisOK(T t) {
		if (CollectionUtils.isNotEmpty(mergeElems)) {
			for (String mergeElem : mergeElems) {
				try {
					Object v = ClassUtil.getClassUtil().getFieldValeWithException(mergeElem, t);
					if (v == null || StringUtils.isEmpty(v.toString())) {
						return false;
					}
				} catch (Exception e) {
					log.error("当前下标位" + getIndex() + "变量名" + VariableConstant.INDEX_DESC.get(getIndex()) + "取"
							+ mergeElem + "字段异常", e);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 子类实现聚合逻辑
	 * 
	 * @param t
	 */
	protected abstract void childMerge(T t);

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	protected abstract String getV() throws Exception;

}

