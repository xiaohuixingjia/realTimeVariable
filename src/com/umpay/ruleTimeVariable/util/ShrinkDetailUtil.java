package com.umpay.ruleTimeVariable.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.umpay.ruleTimeVariable.bean.AbstractDataPo;

/**
 * @ClassName: ShrinkDetailUtil
 * @Description:
 * @param <T>
 * @date 2017年11月9日 下午2:55:22
 */
public class ShrinkDetailUtil {

	/**
	 * 按照时间周期进行分组 key为数字，代表 第n个timePeriod周期 value为周期结果 从1开始
	 * 
	 * @param timePeriod
	 *            周期（以多少天来分一组）
	 * @param detailList
	 *            数据集
	 * @param obsDate
	 * @return
	 * @return List<DetailPo>
	 */
	public static <T extends AbstractDataPo> Map<Integer, List<T>> groupByTimePeriod(int timePeriod, List<T> detailList,
			Date obsDate) {
		Map<Integer, List<T>> groupMap = new HashMap<Integer, List<T>>();
		// 1.遍历detail明细,按照近多少天进行分组,每天一组,Map的Key是天数
		Map<Integer, List<T>> detailMapByDate = getDetailMapByDate(detailList, obsDate);
		// 2.按周期分组
		for (Entry<Integer, List<T>> entry : detailMapByDate.entrySet()) {
			Integer key = (entry.getKey() / timePeriod) + 1;
			if (!groupMap.containsKey(key)) {
				groupMap.put(key, new ArrayList<T>());
			}
			groupMap.get(key).addAll(entry.getValue());
		}
		return groupMap;
	}

	/**
	 * 遍历detail明细,按照每天一组,Map的Key是距离观察日obsDate相差的天数
	 * 
	 * @param detailList
	 * @param obsDate
	 * @return
	 */
	public static <T extends AbstractDataPo> Map<Integer, List<T>> getDetailMapByDate(List<T> detailList,
			Date obsDate) {
		Map<Integer, List<T>> detailMapByDate = new HashMap<Integer, List<T>>();
		for (T t : detailList) {
			if (StringUtils.isEmpty(t.getDate()) || t.getDate().length() < 8)
				continue;
			String yyyyMMdd = t.getDate().substring(0, 8);
			int dayDiff = 0;
			try {
				dayDiff = DateUtil.getDayDiff(DateUtil.string2Date_yyyyMMdd(yyyyMMdd), obsDate);
			} catch (Exception e) {
				continue;
			}
			if (!detailMapByDate.containsKey(dayDiff)) {
				detailMapByDate.put(dayDiff, new ArrayList<T>());
			}
			detailMapByDate.get(dayDiff).add(t);
		}
		return detailMapByDate;
	}
}
