package com.umpay.ruleTimeVariable.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	public static String getCurrentDate(String format) {
    	Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }
	
	/**
	 * 时间差，秒
	 */
	public static int getTimeDifference(Date d1,Date d2){
		long a = d1.getTime();
		long b = d2.getTime();
		int c = (int)((a - b) / 1000);
		return Math.abs(c);
	}

    public static String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static String getDate8(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try{
            return dateFormat.format(date);
        }catch (Exception e) {
            return dateFormat.format(new Date());
        }
    }

    public static String getDate10(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            return dateFormat.format(date);
        }catch (Exception e) {
            return dateFormat.format(new Date());
        }
    }

    public static String getTime14(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try{
            return dateFormat.format(date);
        }catch (Exception e) {
            return dateFormat.format(new Date());
        }
    }
    
    public static String getTime6(Date date){
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        try{
            return dateFormat.format(date);
        }catch (Exception e) {
            return dateFormat.format(new Date());
        }
    }

    public static String getTime14(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }

    public static Date string2Date(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    public static String DateTostring10(Date d){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        try {
            return dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    public static String DateTostring14(Date d){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    public static String DateTostring19(Date d){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    public static String DateTostring19Time(Date d){
        DateFormat dateFormat = new SimpleDateFormat(" HH:mm:ss");
        try {
            return dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public static Date string10ToDate(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public static Date string14ToDate(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public static Date string8ToDate(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    public static Date string2Date_yyyyMMdd(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getDate6(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMM");

        try{
            return dateFormat.format(date);
        }catch (Exception e) {
            return dateFormat.format(new Date());
        }
    }    
    public static String getTime(Date date){
        if(date == null){
            return " 00:00:00";
        }else{
        	return DateTostring19Time(date);
        }
    }

    public static String getTime(int m){
        if(m>=1440 || m<=0){
            return " 00:00:00";
        }

        if(m%60 == 0){
            return new StringBuffer(" ").append(completion(m/60)).append(":00:00").toString();
        }else {
            return new StringBuffer(" ").append(completion(m/60)).append(":").append(completion(m%60)).append(":00").toString();
        }
    }

    private static String completion(int i){
        if(i<10){
            return "0"+i;
        }else{
            return String.valueOf(i);
        }
    }

    public static String getNextHour(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR,num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        return dateFormat.format(date);
    }

    public static String getNextHour(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR,num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        return dateFormat.format(date);
    }

    public static String getNextDay(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String getNextDay(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }
    
    public static String getNextTimestamp(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static Date getNextDay(Date d){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
    /**
     * +n  获取n天后的时间
     * -n  获取n天前的时间
     * @param d
     * @param n
     * @return
     */
    public static Date getNDay(Date d,int n){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, n);
        return calendar.getTime();
    }

    public static String getNextMonth(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    
    public static String getBeforeMonth(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,(-1)*num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(date);
    }

    public static String getNextMonth(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH,num);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static String getNextWeek(int num){
        return getNextDay(num*7);
    }

    public static String getNextWeek(Date d,int num){
        return getNextDay(d,num*7);
    }

    public static String getNextQuarter(int num){
        return getNextMonth(num*3);
    }

    public static String getNextYear(int num){
        return getNextMonth(num * 12);
    }
    
    
    public static String beforeYear(int num){
        return getBeforeMonth(num * 12);
    }

    public static String dateFormat(String datetime,int m) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, m*(-1));  
        date = cl.getTime();  
        return sdf.format(date);  
    }  

    public static long getIntervalSecound(Date d1,Date d2){
    	if(d1 == null || d2 == null)return -1;
    	return Math.abs((d1.getTime() - d2.getTime())/1000);
    }
    
    public static String getTime17(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return dateFormat.format(new Date());
    } 
    
    public static int getWeek(Date date) {
    	GregorianCalendar g = new GregorianCalendar();
    	g.setTime(date);
    	return g.get(Calendar.WEEK_OF_YEAR);//获得周数
    	}
    
    /**
     * 得到的月份比实际月份少1   比如：现在5月，则会返回4
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
    	GregorianCalendar g = new GregorianCalendar();
    	g.setTime(date);
    	return g.get(Calendar.MONTH);//获得月份
    }
    public static int getDayOfYear(Date date) {
    	GregorianCalendar g = new GregorianCalendar();
    	g.setTime(date);
    	return g.get(Calendar.DAY_OF_YEAR);//获得周数
    }
    
    /**
     * 得到某年某月的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static  String getFirstDayOfMonth(int year, int month) {
    
     Calendar cal = Calendar.getInstance();
    
     cal.set(Calendar.YEAR, year);
    
     cal.set(Calendar.MONTH, month-1);
    
     cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
    
    
     return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
     
    /**
     * 得到某年某月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
    
     Calendar cal = Calendar.getInstance();
    
     cal.set(Calendar.YEAR, year);
    
     cal.set(Calendar.MONTH, month-1);
    
      cal.set(Calendar.DAY_OF_MONTH, 1);
     int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
     cal.set(Calendar.DAY_OF_MONTH, value);
    
     return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    
    }
    
    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }
    
    /**
	 * 
	 * @param datestr YYYY-MM-DD 或 YYYY/MM/DD 或  YYYY-MM-DD HH24:mi：ss
	 * @return YYYY-MM-DD HH24:mi：ss
	 */
	public static String getTimeStampStr(String timestr) {
		return getTimeStampStr(timestr,true);
	
	}
	/**
	 * 
	 * @param datestr  YYYY-MM-DD 或 YYYY/MM/DD 或  YYYY-MM-DD HH24:mi：ss
	 * @param isStart  TRUE开始已00:00:00  FALSE结束以23:59:59
	 * @return YYYY-MM-DD HH24:mi：ss
	 */
	public static String getTimeStampStr(String datestr,boolean isStart) {
		if(StringUtils.isEmpty(datestr)){
			return null;
		}
		if(ValidatorUtils.isTimeStampStr(datestr)){
			return datestr;
		}
		/*by mqw*/
		String[] split = datestr.split("[-|/|]");
		
		if(split.length>=3){
			String yearString = split[0];
			String monthString = split[1];
			String dayString = split[2];
			if(split[1].length()==1){
				monthString = "0"+split[1];
			}
			if(split[2].length()==1){
				dayString = "0"+split[2];
			}
			datestr = yearString+"-"+monthString+"-"+dayString;
		}
		
		
		return formatDatetime(datestr,isStart);
		
	}
	
	private static String formatDatetime(String datestr,boolean isStart) {
		if(ValidatorUtils.isTimeStampStr(datestr)){
			return datestr;
		}else if(ValidatorUtils.isDateStr(datestr)){
			datestr = datestr.replaceAll("[-|/]", "");
			String time = isStart==true?" 00:00:00" :" 23:59:59";
			datestr = datestr.substring(0, 4)+"-"+datestr.substring(4,6)+"-"+datestr.substring(6,8)+time;
			return datestr;
		}else {
			return null; 
		}
	}
	
	/**
	 * 计算两个日期相差月份
	 * @param now
	 * @param pre
	 * @return
	 * @throws Exception
	 */
	public static int differMonth(String now,String pre) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(now));
        aft.setTime(sdf.parse(pre));
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        int abs = Math.abs(month + result);
        return abs;   
    }
	
	
    public static long getDistanceDays(String str1, String str2){  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Date one;  
        Date two;  
        long days=0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            days = diff / (1000 * 60 * 60 * 24);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return days;  
    }  
	

	
	
	/**
	 * 某个日期yyyymmdd是否在date1和date2之间
	 * @param date1(小)
	 * @param date2(大)
	 * @param date
	 * @return
	 */
	public static boolean isInInterval(Date date1,Date date2,Date date){
		if(date.after(date1) && date.before(date2))return true;
		return false;
	}
	
	/**
	 * 取两个时间点之间的月份,例如取2017年1月23号到2017年3月10号,结果{201701,201702,201703}
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getYYYYmmByStartDateAndEndDate(Date startDate,Date endDate){
		List<String> result = new ArrayList<String>();
		if(startDate.after(endDate))return result;
		
		String startYYYYmm = DateUtil.getDate6(startDate);
		String endYYYYmm = DateUtil.getDate6(endDate);
		result.add(endYYYYmm);
		while(startYYYYmm.equals(endYYYYmm) == false){
			result.add(startYYYYmm);
			startDate = DateUtil.getNextDateMonth(startDate, 1);
			startYYYYmm = DateUtil.getDate6(startDate);
		}
		return result;
	}
	
    public static Date getNextDateHour(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR, num);
        return calendar.getTime();
    }
    
    public static Date getNextDateDay(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }
    
    public static Date getNextDateWeek(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.WEEK_OF_YEAR, num);
        return calendar.getTime();
    }
    
    public static Date getNextDateMonth(Date d,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH, num);
        return calendar.getTime();
    }
    
   
    /** 
     *  获取两个日期相差的月数 
     * @param d1 
     * @param d2 
     * @return  
     */  
    public static int getMonthDiff(Date d1, Date d2) {  
        Calendar c1 = Calendar.getInstance();  
        Calendar c2 = Calendar.getInstance();  
        c1.setTime(d1);  
        c2.setTime(d2);  
        //if(c1.getTimeInMillis() < c2.getTimeInMillis()) return 0;  
        int year1 = c1.get(Calendar.YEAR);  
        int year2 = c2.get(Calendar.YEAR);  
        int month1 = c1.get(Calendar.MONTH);  
        int month2 = c2.get(Calendar.MONTH);  
        int day1 = c1.get(Calendar.DAY_OF_MONTH);  
        int day2 = c2.get(Calendar.DAY_OF_MONTH);  
        // 获取年的差值 假设 d1 = 2015-8-16  d2 = 2011-9-30  
        int yearInterval = year1 - year2;  
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数  
        if(month1 < month2 || month1 == month2 && day1 < day2) yearInterval --;  
        // 获取月数差值  
        int monthInterval =  (month1 + 12) - month2  ;  
        if(day1 < day2) monthInterval --;  
        monthInterval %= 12;  
        return yearInterval * 12 + monthInterval;  
    }
    
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int getDayDiff(Date smdate,Date bdate) throws ParseException    
    {    
    	long between_days=(bdate.getTime()-smdate.getTime())/(1000*3600*24); 
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
    
    public static void main(String[] args) throws ParseException {
    	long st =System.currentTimeMillis();
    	for(int n=-70 ; n<0 ; n++){
	    	System.out.println(
	    			DateUtil.getDayDiff(
	    					DateUtil.getNextDateDay(new Date(),n), 
	    					DateUtil.getNextDateMonth(new Date(),0) 
	    			)
	    	);
    	}
    	long et =System.currentTimeMillis();
    	System.out.println("spend:"+(et - st));
    }    

}
