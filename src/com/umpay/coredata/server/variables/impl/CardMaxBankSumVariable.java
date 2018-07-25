package com.umpay.coredata.server.variables.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.util.ClassUtil;

/**
 * 相同卡则取最大，相同银行则相加
 * 
 * @author xuxiaojia 2018年3月26日
 */
public class CardMaxBankSumVariable extends AbsVariable<DetailPo> {
	public CardMaxBankSumVariable(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public CardMaxBankSumVariable(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}

	private Map<String, Long> map = new HashMap<String, Long>();

	@Override
	protected void childMerge(DetailPo p) {
		String bank_card = p.getBank() + "_" + p.getCardNo();
		// 取配置里的最后一个字段当做值
		long l = Math.abs(Double.valueOf(
				ClassUtil.getClassUtil().getFieldValeNoException(mergeElems.get(mergeElems.size() - 1), p).toString()).longValue());
		if (map.containsKey(bank_card)) {
			if (l < map.get(bank_card)) {
				l = map.get(bank_card);
			}
		}
		map.put(bank_card, l);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	protected String getV() throws Exception {
		if (map.isEmpty()) {
			return null;
		}
		Long l = 0l;
		for (Entry<String, Long> entry : map.entrySet()) {
			l += entry.getValue();
		}
		return String.valueOf(l);
	}

}
