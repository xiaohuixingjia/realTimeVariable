package com.umpay.coredata.server.Factory;

import java.util.ArrayList;
import java.util.List;

import com.umpay.coredata.server.Pretreatmet.Pretreatmet;
import com.umpay.coredata.server.variables.VariableI;
import com.umpay.coredata.server.variables.impl.AmountAmtSumVariable;
import com.umpay.coredata.server.variables.impl.AmountCntCountVariable;
import com.umpay.coredata.server.variables.impl.CardLevelVariable;
import com.umpay.coredata.server.variables.impl.CardMaxBankSumVariable;
import com.umpay.coredata.server.variables.impl.CreditcardAllVariable;
import com.umpay.coredata.server.variables.impl.DateVariable;
import com.umpay.coredata.server.variables.impl.DistinctBankVariable;
import com.umpay.coredata.server.variables.impl.DistinctElemVariable;
import com.umpay.coredata.server.variables.impl.HistoryBorrowCountVariable;
import com.umpay.coredata.server.variables.impl.LastTimeCardBankSumVariable;
import com.umpay.coredata.server.variables.impl.MaxVariable;
import com.umpay.coredata.server.variables.impl.MaxVariableWithM;
import com.umpay.coredata.server.variables.impl.OtherMerBorrowVariable;
import com.umpay.coredata.server.variables.impl.OverdueMonthVariable;
import com.umpay.coredata.server.variables.impl.PeriodVariable;
import com.umpay.coredata.server.variables.impl.RefuseVariable;
import com.umpay.coredata.server.variables.impl.SpecialVariable;
import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.bean.MultiHeadPo;


/**
 * 变量制造工厂
 * 
 * @author xuxiaojia 2018年3月26日
 */
public class VariableFactory {

	
	/**
	 * 获取Detail所有历史变量
	 * @return
	 */
	public static List<VariableI<DetailPo>> getHistoryVariable4Detail() {
		List<VariableI<DetailPo>> vs = new ArrayList<VariableI<DetailPo>>();
		/**所有detail历史变量**/
		vs.add(new MaxVariable<DetailPo>(0,"true","region",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DistinctElemVariable<DetailPo>(1,"true","bank",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DistinctBankVariable<DetailPo>(2,"card=1","cardNo",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DistinctBankVariable<DetailPo>(3,"card=2","cardNo",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new CardLevelVariable(4,"card=1","cardName",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new CardLevelVariable(5,"card=2","cardName",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DistinctElemVariable<DetailPo>(6,"card=1","bank",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DistinctElemVariable<DetailPo>(7,"card=2","bank",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new LastTimeCardBankSumVariable(8,"type=1 and card=1","bank,cardNo,b",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new LastTimeCardBankSumVariable(9,"type=1 and card=2","bank,cardNo,b",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DateVariable(10,"card=1","date[year,month:first]",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DateVariable(11,"card=1","date[year,month:lastest]",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DateVariable(12,"card=2","date[year,month:first]",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new DateVariable(13,"card=2","date[year,month:lastest]",Pretreatmet.history4detailAuthPretreatmet));
		vs.add(new SpecialVariable(14,"e=1 and type=12",null,Pretreatmet.specialPretreatmet));
		vs.add(new HistoryBorrowCountVariable<DetailPo>(15,"type=12 and e=1",null,Pretreatmet.specialPretreatmet));
		vs.add(new HistoryBorrowCountVariable<DetailPo>(16,"type=12 and e=2",null,Pretreatmet.specialPretreatmet));
		vs.add(new DateVariable(17,"type=12","date[year,month:first]",Pretreatmet.specialPretreatmet));
		vs.add(new DateVariable(18,"type=12","date[year,month:lastest]",Pretreatmet.specialPretreatmet));
		vs.add(new MaxVariable<DetailPo>(19,"type=6 and card=2","a",Pretreatmet.OtherPretreatmet2));
		vs.add(new CreditcardAllVariable(20,"type=6 and card=2","a",Pretreatmet.OtherPretreatmet2));
		
		vs.add(new RefuseVariable(21,"type=4 and a=1",null));
		vs.add(new RefuseVariable(22,"type=4 and a=2",null));
		vs.add(new RefuseVariable(23,"type=4 and a=3",null));
		vs.add(new RefuseVariable(24,"type=4 and a=5",null));
		vs.add(new RefuseVariable(25,"type=4 and a=4",null));
		/**所有逾期历史变量**/
		vs.add(new AmountCntCountVariable<DetailPo>(26,"type=13",null,Pretreatmet.OverduePretreatmet));
		vs.add(new CardMaxBankSumVariable(27,"type=13","c",Pretreatmet.OverduePretreatmet));
		vs.add(new MaxVariable<DetailPo>(28,"type=13","c",Pretreatmet.OverduePretreatmet));
		vs.add(new MaxVariableWithM(29,"type=13","b",Pretreatmet.OverduePretreatmet));
		vs.add(new DistinctElemVariable<DetailPo>(30,"type=13","bank",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(31,"type=13","bank,b","(0,30]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(32,"type=13","bank,b","(30,60]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(33,"type=13","bank,b","(60,90]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(34,"type=13","bank,b","(90,-1]",Pretreatmet.OverduePretreatmet));
		return vs;
	}
	
	public static List<VariableI<MultiHeadPo>> getHistoryVariable4MultiHead() {
		List<VariableI<MultiHeadPo>> vs = new ArrayList<VariableI<MultiHeadPo>>();
		/**所有多投历史变量**/
		vs.add(new AmountAmtSumVariable<MultiHeadPo>(35,"true","borrowCnt"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(36,"true","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(37,"mertType=8","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(38,"mertType=4","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(39,"mertType=1","mertId"));
		vs.add(new OtherMerBorrowVariable(40,"true","mertId"));
		return vs;
	}
	
	
	/**
	 * 获取Detail所有30天变量
	 * @return
	 */
	public static List<VariableI<DetailPo>> getThirtyDaysVariable4Detail() {
		List<VariableI<DetailPo>> vs = new ArrayList<VariableI<DetailPo>>();
		vs.add(new LastTimeCardBankSumVariable(0,"type=1 and card=1","b",Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(1,"type=1 and card=1 and c=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(2,"type=1 and card=1 and c=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(3,"type=1 and card=1 and c=1 and f like 取现,取款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(4,"type=1 and card=1 and c=1 and f like 取现,取款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(5,"type=1 and card=1 and c=1 and e=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(6,"type=1 and card=1 and c=1 and e=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(7,"type=1 and card=1 and c=1 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(8,"type=1 and card=1 and c=1 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(9,"type=1 and card=1 and c=1 and f like 贷","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(10,"type=1 and card=1 and c=1 and f like 贷",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(11,"type=1 and card=1 and c=1 and d=8","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(12,"type=1 and card=1 and c=1 and d=8",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(13,"type=1 and card=1 and c=1 and d=7",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(14,"type=1 and card=1 and c=1 and d=7","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(15,"type=1 and card=1 and c=1 and d=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(16,"type=1 and card=1 and c=1 and d=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(17,"type=1 and card=1 and c=1 and d=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(18,"type=1 and card=1 and c=1 and d=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(19,"type=1 and card=1 and c=1 and d=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(20,"type=1 and card=1 and c=1 and d=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(21,"type=1 and card=1 and c=1 and g=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(22,"type=1 and card=1 and c=1 and g=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(23,"type=1 and card=1 and c=1 and g=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(24,"type=1 and card=1 and c=1 and g=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(25,"type=1 and card=1 and c=1 and g=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(26,"type=1 and card=1 and c=1 and g=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(27,"type=1 and card=1 and c=1 and g=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(28,"type=1 and card=1 and c=1 and g=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(29,"type=1 and card=1 and c=1 and g=4","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(30,"type=1 and card=1 and c=1 and g=4",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(31,"type=1 and card=1 and c=1 and g=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(32,"type=1 and card=1 and c=1 and g=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(33,"type=1 and card=1 and c=1 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(34,"type=1 and card=1 and c=1 and f like 还款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(35,"type=1 and card=1 and c=1 and d=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(36,"type=1 and card=1 and c=1 and d=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(37,"type=1 and card=1 and c=1 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(38,"type=1 and card=1 and c=1 and e=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(39,"type=1 and card=1 and c=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(40,"type=1 and card=1 and c=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(41,"type=1 and card=1 and c=2 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(42,"type=1 and card=1 and c=2 and f like 还款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(43,"type=1 and card=1 and c=2 and f like 工资","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(44,"type=1 and card=1 and c=2 and f like 工资",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(45,"type=1 and card=1 and c=2 and d=8","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(46,"type=1 and card=1 and c=2 and d=8",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(47,"type=1 and card=1 and c=2 and d=7","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(48,"type=1 and card=1 and c=2 and d=7",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(49,"type=1 and card=1 and c=2 and d=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(50,"type=1 and card=1 and c=2 and d=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(51,"type=1 and card=1 and c=2 and d=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(52,"type=1 and card=1 and c=2 and d=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(53,"type=1 and card=1 and c=2 and d=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(54,"type=1 and card=1 and c=2 and d=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(55,"type=1 and card=1 and c=2 and g=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(56,"type=1 and card=1 and c=2 and g=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(57,"type=1 and card=1 and c=2 and g=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(58,"type=1 and card=1 and c=2 and g=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(59,"type=1 and card=1 and c=2 and g=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(60,"type=1 and card=1 and c=2 and g=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(61,"type=1 and card=1 and c=2 and g=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(62,"type=1 and card=1 and c=2 and g=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(63,"type=1 and card=1 and c=2 and g=4","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(64,"type=1 and card=1 and c=2 and g=4",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(65,"type=1 and card=1 and c=2 and g=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(66,"type=1 and card=1 and c=2 and g=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(67,"type=1 and card=1 and c=2 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(68,"type=1 and card=1 and c=2 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(69,"type=1 and card=1 and c=2 and d=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(70,"type=1 and card=1 and c=2 and d=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(71,"type=1 and card=1 and c=2 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(72,"type=1 and card=1 and c=2 and e=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(73,"type=1 and card=1 and c=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(74,"type=1 and card=1 and c=1 and f like 取现,取款","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(75,"type=1 and card=1 and c=1 and e=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(76,"type=1 and card=1 and c=1 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(77,"type=1 and card=1 and c=1 and f like 贷","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(78,"type=1 and card=1 and c=1 and d=8","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(79,"type=1 and card=1 and c=1 and d=7","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(80,"type=1 and card=1 and c=1 and d=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(81,"type=1 and card=1 and c=1 and d=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(82,"type=1 and card=1 and c=1 and d=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(83,"type=1 and card=1 and c=1 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(84,"type=1 and card=1 and c=1 and d=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(85,"type=1 and card=1 and c=1 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(86,"type=1 and card=1 and c=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(87,"type=1 and card=1 and c=2 and f like 工资","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(88,"type=1 and card=1 and c=2 and d=8","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(89,"type=1 and card=1 and c=2 and d=7","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(90,"type=1 and card=1 and c=2 and d=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(91,"type=1 and card=1 and c=2 and d=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(92,"type=1 and card=1 and c=2 and d=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(93,"type=1 and card=1 and c=2 and f like 理财,股票,基金,保险,保费,保险费,信托,投资,赎回,申购,期货,结息,结转,本息,证券,银转证,易方达,净值","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(94,"type=1 and card=1 and c=2 and d=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(95,"type=1 and card=1 and c=2 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(96,"type=1 and card=2 and c=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(97,"type=1 and card=2 and  c=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(98,"type=1 and card=2 and  c=1 and f like 取现,取款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(99,"type=1 and card=2 and  c=1 and f like 取现,取款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(100,"type=1 and card=2 and  c=1 and e=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(101,"type=1 and card=2 and  c=1 and e=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(102,"type=1 and card=2 and  c=1 and g=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(103,"type=1 and card=2 and  c=1 and g=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(104,"type=1 and card=2 and  c=1 and g=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(105,"type=1 and card=2 and  c=1 and g=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(106,"type=1 and card=2 and  c=1 and g=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(107,"type=1 and card=2 and  c=1 and g=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(108,"type=1 and card=2 and  c=1 and g=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(109,"type=1 and card=2 and  c=1 and g=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(110,"type=1 and card=2 and  c=1 and g=4","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(111,"type=1 and card=2 and  c=1 and g=4",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(112,"type=1 and card=2 and  c=1 and g=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(113,"type=1 and card=2 and  c=1 and g=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(114,"type=1 and card=2 and  c=1 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(115,"type=1 and card=2 and  c=1 and f like 还款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(116,"type=1 and card=2 and  c=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(117,"type=1 and card=2 and  c=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(118,"type=1 and card=2 and  c=2 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(119,"type=1 and card=2 and  c=2 and f like 还款",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(120,"type=1 and card=2 and  c=2 and g=6","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(121,"type=1 and card=2 and  c=2 and g=6",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(122,"type=1 and card=2 and  c=2 and g=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(123,"type=1 and card=2 and  c=2 and g=1",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(124,"type=1 and card=2 and  c=2 and g=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(125,"type=1 and card=2 and  c=2 and g=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(126,"type=1 and card=2 and  c=2 and g=3","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(127,"type=1 and card=2 and  c=2 and g=3",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(128,"type=1 and card=2 and  c=2 and g=4","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(129,"type=1 and card=2 and  c=2 and g=4",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(130,"type=1 and card=2 and  c=2 and g=5","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(131,"type=1 and card=2 and  c=2 and g=5",null,Pretreatmet.TradePretreatmet));
		vs.add(new AmountAmtSumVariable<DetailPo>(132,"type=1 and card=2 and c=2 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(133,"type=1 and card=2 and c=2 and e=2",null,Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(134,"type=1 and card=2 and c=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(135,"type=1 and card=2 and c=1 and f like 取现,取款","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(136,"type=1 and card=2 and c=1 and e=1","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(137,"type=1 and card=2 and c=1 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(138,"type=1 and card=2 and c=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(139,"type=1 and card=2 and c=2 and f like 还款","a",Pretreatmet.TradePretreatmet));
		vs.add(new MaxVariable<DetailPo>(140,"type=1 and card=2 and c=2 and e=2","a",Pretreatmet.TradePretreatmet));
		vs.add(new CardMaxBankSumVariable(141,"type=2 and card=2","a",Pretreatmet.OtherPretreatmet));
		vs.add(new AmountCntCountVariable<DetailPo>(142,"type=2 and card=2",null,Pretreatmet.OtherPretreatmet));
		vs.add(new LastTimeCardBankSumVariable(143,"type=2 and card=2","b",Pretreatmet.OtherPretreatmet));
		vs.add(new LastTimeCardBankSumVariable(144,"type=6 and card=2","b",Pretreatmet.OtherPretreatmet));
		/**被拒次数**/
		vs.add(new RefuseVariable(145,"type=4 and a=1",null));
		vs.add(new RefuseVariable(146,"type=4 and a=2",null));
		vs.add(new RefuseVariable(147,"type=4 and a=3",null));
		vs.add(new RefuseVariable(148,"type=4 and a=5",null));
		vs.add(new RefuseVariable(149,"type=4 and a=4",null));
		/**逾期变量**/
		vs.add(new AmountCntCountVariable<DetailPo>(150,"type=13",null,Pretreatmet.OverduePretreatmet));
		vs.add(new CardMaxBankSumVariable(151,"type=13","c",Pretreatmet.OverduePretreatmet));
		vs.add(new MaxVariable<DetailPo>(152,"type=13","c",Pretreatmet.OverduePretreatmet));
		vs.add(new MaxVariableWithM(153,"type=13","b",Pretreatmet.OverduePretreatmet));
		vs.add(new DistinctElemVariable<DetailPo>(154,"type=13","bank",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(155,"type=13","bank,b","(0,30]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(156,"type=13","bank,b","(30,60]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(157,"type=13","bank,b","(60,90]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(158,"type=13","bank,b","(90,-1]",Pretreatmet.OverduePretreatmet));
		return vs;
	}


	/**
	 * 获取实时30天的多投变量
	 * @param vs
	 */
	public static List<VariableI<MultiHeadPo>> getThirtyDaysVariable4MultiHeadPo() {
		List<VariableI<MultiHeadPo>> vs=new ArrayList<VariableI<MultiHeadPo>>();
		/**多投变量**/
		vs.add(new AmountAmtSumVariable<MultiHeadPo>(159,"true","borrowCnt"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(160,"true","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(161,"mertType=8","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(162,"mertType=4","mertId"));
		vs.add(new DistinctElemVariable<MultiHeadPo>(163,"mertType=1","mertId"));
		vs.add(new OtherMerBorrowVariable(164,"true","mertId"));
		return vs;
	}
	
	
	/**
	 * 获取所有一年变量
	 * @return
	 */
	public static List<VariableI<DetailPo>> getOneyearVariable() {
		List<VariableI<DetailPo>> vs = new ArrayList<VariableI<DetailPo>>();
		/**detail变量**/
		vs.add(new PeriodVariable(0,"type=12 and card=2",null,Pretreatmet.OtherPretreatmet2));
		vs.add(new MaxVariable<DetailPo>(1,"type=12 and card=2","b",Pretreatmet.OtherPretreatmet2));
		/**逾期变量**/
		vs.add(new DistinctElemVariable<DetailPo>(2,"type=13","bank",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(3,"type=13","bank,b","(0,30]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(4,"type=13","bank,b","(30,60]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(5,"type=13","bank,b","(60,90]",Pretreatmet.OverduePretreatmet));
		vs.add(new OverdueMonthVariable(6,"type=13","bank,b","(90,-1]",Pretreatmet.OverduePretreatmet));
		return vs;
	}
}
