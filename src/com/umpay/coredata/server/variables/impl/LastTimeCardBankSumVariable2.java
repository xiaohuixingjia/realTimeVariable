package com.umpay.coredata.server.variables.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.umpay.coredata.server.Factory.ConditionFactory;
import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.AbsVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;

/**
 * 卡值取最近的，相同银行下相加 
 * 
 * @author xuxiaojia 2018年3月25日
 */
public class LastTimeCardBankSumVariable2 extends AbsVariable<DetailPo> {

	public LastTimeCardBankSumVariable2(int index, String conditionStr, String mergeElems) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems);
	}
	public LastTimeCardBankSumVariable2(int index, String conditionStr, String mergeElems,Pretreatmet pretreatmet) {
		super(index, ConditionFactory.getCD(conditionStr), mergeElems,pretreatmet);
	}

	private Map<String, CardAmtInfo> amtOfCardNum_map = new HashMap<String, CardAmtInfo>();

	@Override
	protected void childMerge(DetailPo p) {
		String uniqueCardPo = p.getBank() + "_" + p.getCardNo();
		if (amtOfCardNum_map.containsKey(uniqueCardPo)) {
			try {
				amtOfCardNum_map.get(uniqueCardPo).compareDate2change(p);
			} catch (Exception e) {
//				e.printStackTrace();
			}
		} else {
			try {
				amtOfCardNum_map.put(uniqueCardPo, new CardAmtInfo(p));
			} catch (Exception e) {
//				e.printStackTrace();
			}
//			System.out.println(p.getDate() + ":" +new CardAmtInfo(p).getAmt());
		}
	}

	@Override
	public void clear() {
		amtOfCardNum_map.clear();
	}

	@Override
	protected String getV() throws Exception {
		
		boolean nullFlag = true;
		for (Entry<String, CardAmtInfo> entry : amtOfCardNum_map.entrySet()) {
			if(entry.getValue().getAmt()!=null){
				nullFlag = false;
			}
		}
		
		if (amtOfCardNum_map.isEmpty()) {
			return null;
		}
		
		if(nullFlag == false){
			Long f = 0l;
			for (Entry<String, CardAmtInfo> entry : amtOfCardNum_map.entrySet()) {
				f += entry.getValue().getAmt() == null?0:entry.getValue().getAmt();
			}
			return String.valueOf(f);
		}else{
			return "";
		}
	}

	private class CardAmtInfo {
		private Long amt;
		private String date;
		private String time;

		public CardAmtInfo(DetailPo p) {
			if(p.getA()==null || "".equals(p.getA())){
				amt = null; 
			}else{
				amt = Math.abs(Double.valueOf(p.getA()).longValue());
			}
			date = p.getDate();
			time = p.getTime();
		}

		/**
		 * 取时间最大的（也就是时间最近于当前时间的）余额
		 * 
		 * @param p
		 */
		public void compareDate2change(DetailPo p) {
			if(date.compareTo(p.getDate())<0){
				if(p.getA()==null || "".equals(p.getA())){
					this.amt = null;
				}else{
					this.amt = Math.abs(Double.valueOf(p.getA()).longValue());
				}
				this.date=p.getDate();
				this.time=p.getTime();
			}else if (date.compareTo(p.getDate())==0&&time.compareTo(p.getTime())<0){
				if(p.getA()==null || "".equals(p.getA())){
					this.amt = null;
				}else{
					this.amt = Math.abs(Double.valueOf(p.getA()).longValue());
				}
				this.date=p.getDate();
				this.time=p.getTime();
			}
		}

		public Long getAmt() {
			return amt;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Math.abs(5));
	}
}

