package com.umpay.ruleTimeVariable.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
/**
 * 正则验证工具
 * @author xuechongyang
 *
 */
public class ValidatorUtils {
	
    /** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
    
    /** 
     * 验证固定电话号码 
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447 
     * 国家（地区） 代码 ：标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字， 
     *  数字之后是空格分隔的国家（地区）代码。 
     * 区号（城市代码）：这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号—— 
     * 对不使用地区或城市代码的国家（地区），则省略该组件。 
     * 电话号码：这包含从 0 到 9 的一个或多个数字  
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkPhone(String phone) {   
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";   
        return Pattern.matches(regex, phone);   
    }   
 
 
    /** 
     * 邮箱验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean checkEmail(String email){  
        boolean flag = false;  
        try{  
         String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
         Pattern regex = Pattern.compile(check);  
         Matcher matcher = regex.matcher(email);  
         flag = matcher.matches();  
        }catch(Exception e){  
         flag = false;  
        }  
          
        return flag;  
       } 
    
    /**
     * 是否包含汉字
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     * @param value 指定的字符串
     * @return 字符串的长度
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }
    

    /** 
     * 网络电话验证 
     *  (170|710|\+87|116|019|400|18[019])\d{8,}  
     *  010-567/170/710/+87/116/019/400/176/177/178等  
     * @param  str 
     * @return 验证通过返回true 
     * 
     */  
    public static boolean isNetPhone(String str) {
    	if(StringUtils.isEmpty(str))return false;
    	str = str.replaceAll("\\+", "");
        Pattern p1 = Pattern.compile("^(170|176|177|178|710|116|019|400|87)[0-9]{5,}$"); // 验证170|710|116|019|400开头  
        Pattern p2 = Pattern.compile("^(010-567)[0-9]{3,}$"); // 010-567开头
        
        if(p1.matcher(str).matches()||p2.matcher(str).matches()){
        	return true;
        }
        return false;  
    } 
    
    /**
     * 是否是时间戳格式 YYYY-MM-DD HH24:mi：ss
     * @param str
     * @return
     */
    public static boolean isTimeStampStr(String str) {   
    	if(str==null||str=="")return false;
    	Pattern p1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}(\\.\\d{1,})?$"); 
    	if(p1.matcher(str).matches()){
    		return true;
    	}
    	return false;  
    }
    /**
     * 是否是日期格式
     * @param str
     * @return
     */
    public static boolean isDateStr(String str) {
    	if(str==null||str=="")return false;
    	Pattern p1 = Pattern.compile("^\\d{4}[-|/]?\\d{2}[-|/]?\\d{2}$"); 
    	if(p1.matcher(str).matches()){
    		return true;
    	}
    	return false;  
    }
    /**
     * 是否是日期格式
     * @param str
     * @return
     */
    public static boolean isDate10Str(String str) {
    	if(str==null||str=="")return false;
    	Pattern p1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$"); 
    	if(p1.matcher(str).matches()){
    		return true;
    	}
    	return false;  
    }
    /**
     * 是否是日期格式 2010-10
     * @param str
     * @return
     */
    public static boolean isMonth7Str(String str) {
    	if(str==null||str=="")return false;
    	Pattern p1 = Pattern.compile("^\\d{4}-\\d{2}$"); 
    	if(p1.matcher(str).matches()){
    		return true;
    	}
    	return false;  
    }
    
    /**
     *  1-54
     * @param str
     * @return
     */
    public static boolean isWeekNumber(String str) {
    	if(str==null||str=="")return false;
    	try {
    		int week = Integer.parseInt(str);
			if ( week< 55 && week > 0)return true;
		} catch (Exception e) {
		}
		return false;
	}
    
   
    /**
     * 是否是整数
     * @param str
     * @return
     */
    public static boolean isNumeric1(String str){
    	if(StringUtils.isEmpty(str))return false;
     Pattern pattern = Pattern.compile("[0-9]*");
     return pattern.matcher(str).matches();
    }
    /**
     * 是否是数字
     * @param str
     * @return
     */
    public static boolean isDigit(String str){
    	if(StringUtils.isEmpty(str))return false;
    	Pattern pattern = Pattern.compile("(\\d+)|(\\d+\\.\\d+)");
    	return pattern.matcher(str).matches();
    }
	
    
   public static void main(String[] args) {
	System.out.println(isDigit("1.2"));
}
     
     

}
