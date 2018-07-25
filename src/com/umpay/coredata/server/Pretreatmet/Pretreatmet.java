package com.umpay.coredata.server.Pretreatmet;

import org.apache.commons.lang.StringUtils;

import com.umpay.coredata.server.constant.BankConstant;
import com.umpay.coredata.server.constant.Card;
import com.umpay.coredata.server.constant.TradeStatus;
import com.umpay.coredata.server.constant.Type;
import com.umpay.ruleTimeVariable.bean.DetailPo;


/**
 * 预处理枚举
 *    所有的预处理 除了DoNothingPretreatmet 外其他的预处理的逻辑都依照月表字典进行开发
 * @author xuxiaojia
 */
public enum Pretreatmet {
	/**
	 * 交易预处理
	 */
	TradePretreatmet {
		@Override
		public DetailPo excute(DetailPo po) {
			// 在交易类型为1的情况下 子数据类型为1则过滤掉
			if ("1".equals(po.getType()) && "1".equals(checkTradeType(po))) {
				return null;
			}
			// 非个人账户 过滤掉
			if (!"1".equals(po.getAccount())) {
				return null;
			}
			// 非银行集合中 过滤掉
			if (!BankConstant.TradeBankList.contains(po.getBank())) {
				return null;
			}
			// v3.1修改逻辑，只取真正的卡类型
			if ("1".equals(po.getType()) && "4".equals(po.getBank()) && (po.getCardName().contains("中银卡")
					|| po.getCardName().contains("长城卡") || po.getCardName().contains("长城白金卡"))) {
				po.setCard("2");
			}
			return po;
		}

		// 设置交易数据集类型，
		// direction 交易方向（1：出账，2：入账） c
		// status 交易状态 h
		// cardType 卡类型：1.储蓄卡 2.信用卡 card
		private String checkTradeType(DetailPo po) {
			String direction = po.getC();
			String cardType = po.getCard();
			String status = po.getH();
			if (TradeStatus.normal.toString().equals(status) && StringUtils.isNotEmpty(po.getA())) {// 四大数据集交易金额必须为非空
				if (Card.debit.toString().equals(cardType) && Type.trade.toString().equals(direction)) {
					return Type.debitOut.toString();
				} else if (Card.debit.toString().equals(cardType) && Type.bill.toString().equals(direction)) {
					return Type.debitIn.toString();
				} else if (Card.credit.toString().equals(cardType) && Type.trade.toString().equals(direction)) {
					return Type.creditOut.toString();
				} else if (Card.credit.toString().equals(cardType) && Type.bill.toString().equals(direction)) {
					return Type.creditIn.toString();
				}
			}
			return "1";
		}

	},

	/**
	 * 逾期预处理
	 */
	OverduePretreatmet {
		@Override
		public DetailPo excute(DetailPo po) {
			// 非银行集合中 过滤掉
			if (!BankConstant.OverdueBankList.contains(po.getBank())) {
				return null;
			}
			// b字段值大于0 则返回
			if ("13".equals(po.getType()) && StringUtils.isNotEmpty(po.getB())) {
				if (Double.parseDouble(po.getB()) > 0) {
					return po;
				}
			}
			return null;
		}
	},

	/**
	 * 其他类月表预处理
	 */
	OtherPretreatmet {
		@Override
		public DetailPo excute(DetailPo po) {
			// 非银行集合中 过滤掉
			if (!BankConstant.TradeBankList.contains(po.getBank())) {
				return null;
			}
			
			if (("2".equals(po.getType()) || "5".equals(po.getType()) || "6".equals(po.getType()))) {
				return po;
			}
			return null;
		}
	},
	
	
	/**
	 * 其他类月表预处理
	 */
	OtherPretreatmet2 {
		@Override
		public DetailPo excute(DetailPo po) {
			// 非银行集合中 过滤掉
			if (!BankConstant.TradeBankList.contains(po.getBank())) {
				return null;
			}
			if (("2".equals(po.getType()) || "5".equals(po.getType()) || "6".equals(po.getType())) || "12".equals(po.getType())) {
				return po;
			}
			return null;
		}
	},
	
	/**
	 * 所有过滤
	 */
	history4detailAuthPretreatmet {
		
		@Override
		public DetailPo excute(DetailPo po) {
			boolean flag = false;
			String type = po.getType().trim();
			
			if("1".equals(type)){
				if(TradePretreatmet.excute(po)!=null){
					flag = true;
				}
			}
			
			if("13".equals(type)){
				if(OverduePretreatmet.excute(po)!=null){
					flag = true;
				}
			}
			
			if("2".equals(type) || "5".equals(type) || "6".equals(type) || "12".equals(type)){
				if(OtherPretreatmet2.excute(po)!=null){
					flag = true;
				}
			}
			
			if(flag){
				return po;
			}else{
				return null;
			}
		}
	},
	/**
	 * 无预处理
	 */
	DoNothingPretreatmet {

		@Override
		public DetailPo excute(DetailPo po) {
			return po;
		}

	},
	
	//历史接单总金额,总笔数|历史结贷总笔数,贷款最早,最近出现月份的过滤条件
	specialPretreatmet{
		@Override
		public DetailPo excute(DetailPo po) {
			if (!BankConstant.OverdueBankList.contains(po.getBank())) {
				return null;
			}
			if("12".equals(po.getType()) && "1".equals(po.getCard()) && ("1".equals(po.getE()) || "2".equals(po.getE()) || "3".equals(po.getE()))){
				return po;
			}else{
				return null;
			}
		}
	};

	public abstract DetailPo excute(DetailPo po);
}
