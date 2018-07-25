package com.umpay.ruleTimeVariable.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.umpay.ruleTimeVariable.util.ClassUtil;
import com.umpay.ruleTimeVariable.util.ListUtil;

/**
 * Detail明细的模型类
 * @author wangwei
 * 成员变量的字典注释仅为了方便查看，最终以文档为准，请时刻保持同步
 */

public class DetailPo implements AbstractDataPo,Comparable<DetailPo>{
	public static Map<String,Integer> fieldMapping = null; 
	
	
	static {
		fieldMapping = new HashMap<String,Integer>();
		fieldMapping.put("mobile",0);
		fieldMapping.put("region",1);
		fieldMapping.put("name",2);
		fieldMapping.put("sex",3);
		fieldMapping.put("bank",4);
		fieldMapping.put("type",5);
		fieldMapping.put("cardName",6);
		fieldMapping.put("card",7);
		fieldMapping.put("cardNo",8);
		fieldMapping.put("date",9);
		fieldMapping.put("time",10);
		fieldMapping.put("account",11);
		fieldMapping.put("cuurency",12);
		fieldMapping.put("weekday",13);
		fieldMapping.put("a",14);
		fieldMapping.put("b",15);
		fieldMapping.put("c",16);
		fieldMapping.put("d",17);
		fieldMapping.put("e",18);
		fieldMapping.put("f",19);
		fieldMapping.put("g",20);
		fieldMapping.put("h",21);
		fieldMapping.put("i",22);
		fieldMapping.put("j",23);
		fieldMapping.put("k",24);
		fieldMapping.put("l",25);
		fieldMapping.put("m",26);
		fieldMapping.put("n",27);
		fieldMapping.put("o",28);
		fieldMapping.put("p",29);
	}
	
	
	private List<String> dataArray = new ArrayList<String>();
	public void setDataArray(List<String> dataArray) {
		this.dataArray = dataArray;
	}
 	public List<String> getDataArray() {
		return dataArray;
	}
	public String getMobile() {
		return ListUtil.getWithOutException(dataArray,0);
	}
	public String getRegion() {
		return ListUtil.getWithOutException(dataArray,1);
	}
	public String getName() {
		return ListUtil.getWithOutException(dataArray,2);
	}
	public String getSex() {
		return ListUtil.getWithOutException(dataArray,3);
	}
	public String getBank() {
		return ListUtil.getWithOutException(dataArray,4);
	}
	public String getType() {
		return ListUtil.getWithOutException(dataArray,5);
	}
	public String getCardName() {
		return ListUtil.getWithOutException(dataArray,6);
	}
	public String getCard() {
		return ListUtil.getWithOutException(dataArray,7);
	}
	public String getCardNo() {
		return ListUtil.getWithOutException(dataArray,8);
	}
	public String getDate() {
		return ListUtil.getWithOutException(dataArray,9);
	}
	public boolean setDate(String s) {
		return ListUtil.setWithOutException(dataArray,9,s);
	}	
	/**
	 * TODO 修改
	 * @return
	 */
	public String getTime() {
		return ListUtil.getWithOutException(dataArray,10);
	}
	public String getAccount() {
		return ListUtil.getWithOutException(dataArray,11);
	}
	public String getCurrency() {
		return ListUtil.getWithOutException(dataArray,12);
	}
	public String getWeekday() {
		return ListUtil.getWithOutException(dataArray,13);
	}
	
	public String getA() {
		return ListUtil.getWithOutException(dataArray,14);
	}
	public String getB() {
		return ListUtil.getWithOutException(dataArray,15);
	}
	public String getC() {
		return ListUtil.getWithOutException(dataArray,16);
	}
	public String getD() {
		return ListUtil.getWithOutException(dataArray,17);
	}
	public String getE() {
		return ListUtil.getWithOutException(dataArray,18);
	}
	public String getF() {
		return ListUtil.getWithOutException(dataArray,19);
	}
	public String getG() {
		return ListUtil.getWithOutException(dataArray,20);
	}
	public String getH() {
		return ListUtil.getWithOutException(dataArray,21);
	}
	public String getI() {
		return ListUtil.getWithOutException(dataArray,22);
	}
	public String getJ() {
		return ListUtil.getWithOutException(dataArray,23);
	}
	public String getK() {
		return ListUtil.getWithOutException(dataArray,24);
	}
	public String getL() {
		return ListUtil.getWithOutException(dataArray,25);
	}
	public String getM() {
		return ListUtil.getWithOutException(dataArray,26);
	}
	public String getN() {
		return ListUtil.getWithOutException(dataArray,27);
	}
	public String getO() {
		return ListUtil.getWithOutException(dataArray,28);
	}
	public String getP() {
		return ListUtil.getWithOutException(dataArray,29);
	}
	
	public boolean setCard(String s) {
		return ListUtil.setWithOutException(dataArray,7,s);
	}	
	public boolean setA(String s) {
		return ListUtil.setWithOutException(dataArray,14,s);
	}	
	public boolean setB(String s) {
		return ListUtil.setWithOutException(dataArray,15,s);
	}	
	public boolean setC(String s) {
		return ListUtil.setWithOutException(dataArray,16,s);
	}	
	public boolean setD(String s) {
		return ListUtil.setWithOutException(dataArray,17,s);
	}	
	public boolean setE(String s) {
		return ListUtil.setWithOutException(dataArray,18,s);
	}	
	public boolean setF(String s) {
		return ListUtil.setWithOutException(dataArray,19,s);
	}	
	public boolean setG(String s) {
		return ListUtil.setWithOutException(dataArray,20,s);
	}	
	public boolean setH(String s) {
		return ListUtil.setWithOutException(dataArray,21,s);
	}	
	public boolean setI(String s) {
		return ListUtil.setWithOutException(dataArray,22,s);
	}	
	public boolean setJ(String s) {
		return ListUtil.setWithOutException(dataArray,23,s);
	}	
	public boolean setK(String s) {
		return ListUtil.setWithOutException(dataArray,24,s);
	}	
	public boolean setL(String s) {
		return ListUtil.setWithOutException(dataArray,25,s);
	}	
	public boolean setM(String s) {
		return ListUtil.setWithOutException(dataArray,26,s);
	}	
	public boolean setN(String s) {
		return ListUtil.setWithOutException(dataArray,27,s);
	}	
	public boolean setO(String s) {
		return ListUtil.setWithOutException(dataArray,28,s);
	}	
	public boolean setP(String s) {
		return ListUtil.setWithOutException(dataArray,29,s);
	}	
	
	
	public void print(){
		System.out.println("[mobile:"+this.getMobile()+"][region:"+this.getRegion()+"][name:"+this.getName()+"][sex:"+this.getSex()+"][bank:"+this.getBank()+"][type:"+this.getType()+"][cardName:"+this.getCardName()+"]"
				+"[card:"+this.getCard()+"][carNo:"+this.getCardNo()+"][date:"+this.getDate()+"][time:"+this.getTime()+"][account:"+this.getAccount()+"][currency:"+this.getCurrency()+"][weekday:"+this.getWeekday()+"]"
				
				+"[a:"+this.getA()+"][b:"+this.getB()+"][c:"+this.getC()+"][d:"+this.getD()+"][e:"+this.getE()+"][f:"+this.getF()+"][g:"+this.getG()+"]"
				+"[h:"+this.getH()+"][i:"+this.getI()+"][j:"+this.getJ()+"][k:"+this.getK()+"][l:"+this.getL()+"][m:"+this.getM()+"][n:"+this.getN()+"][o:"+this.getO()+"]");
	}

	@Override
	public String toString() {
		return "DetailPo [dataArray=" + dataArray + "]";
	}	
	
	public static void main(String[] args) throws Exception {
		DetailPo po=new DetailPo();
        
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		po.getDataArray().add("12");
		System.out.println(ClassUtil.getClassUtil().getFieldValeWithException("c", po));
	}
	
	@Override
	public int compareTo(DetailPo o) {
		return Integer.parseInt(o.getDate()) - Integer.parseInt(this.getDate());   
	}
}

















