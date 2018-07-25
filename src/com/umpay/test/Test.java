package com.umpay.test;

import java.util.ArrayList;
import java.util.List;

import com.umpay.coredata.server.Factory.VariableFactory;
import com.umpay.coredata.server.variables.VariableI;
import com.umpay.ruleTimeVariable.bean.DetailPo;

public class Test {
	public static void main(String[] args) {
		List<DetailPo> resus = new ArrayList<DetailPo>();
		List<VariableI<DetailPo>> vs = VariableFactory.getHistoryVariable4Detail();
		for (DetailPo po : resus) {
			for (VariableI<DetailPo> variableI : vs) {
				variableI.merge(po);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (VariableI<DetailPo> variableI : vs) {
			builder.append(variableI.get()).append(",");
		}
		System.out.println(builder.toString());
	}
}
