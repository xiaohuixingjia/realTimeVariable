package com.umpay.ruleTimeVariable.util;

import java.lang.reflect.Field;

import com.umpay.ruleTimeVariable.bean.DetailPo;
import com.umpay.ruleTimeVariable.bean.MultiHeadPo;

/**
 * 类相关常用工具类
 * (单例模式需要先调用getClassUtil方法获取对象)
 * @author xuxiaojia
 */
public class ClassUtil {
	private static ClassUtil classUtil = new ClassUtil();

	public static ClassUtil getClassUtil() {
		return classUtil;
	}

	private ClassUtil() {

	}
	
	@SuppressWarnings("rawtypes")
	/**
	 * 获取类下的所有申明的字段
	 * @param c
	 * @return
	 */
	public Field[] getClassFields(Class c){
		Field[] fields= c.getDeclaredFields();
		return fields;
	}
	
	/**
	 * 用反射获取字段的值
	 * @param field 字段
	 * @param t   对象
	 * @return
	 */
	public <T> Object getFieldValue(Field field,T t){
		field.setAccessible(true);
		Object resu=null;
		try {
			resu = field.get(t);
		} catch (Exception e) {
			throw new RuntimeException(t.getClass()+"类的"+field.getName()+"字段取值失败");
		} 
		return resu;
	}
	
	/**
	 * 使用方法反射机制获取对象属性值，所以该对象必须包含该该属性的get方法！！！，获取异常则返回 null
	 */
	public Object getFieldValeNoException(String elemName,Object obj){
		try {
			return getFieldValeWithException(elemName,obj);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 根据字段下表映射获取字段值
	 * 
	 * @param elemName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object getFieldValeWithException(String elemName,Object obj) throws Exception{
		if(obj instanceof DetailPo){
			if(DetailPo.fieldMapping.containsKey(elemName)){
				return ((DetailPo)obj).getDataArray().get(DetailPo.fieldMapping.get(elemName));
			}
		}
		else if(obj instanceof MultiHeadPo){
			if(MultiHeadPo.fieldMapping.containsKey(elemName)){
				return ((MultiHeadPo)obj).getDataArray().get(MultiHeadPo.fieldMapping.get(elemName));
			}
		}
		else{
			if(elemName.length()>1){
				elemName=elemName.substring(0,1).toUpperCase()+elemName.substring(1);
			}else{
				elemName=elemName.toUpperCase();
			}
	        return obj.getClass().getMethod("get"+elemName).invoke(obj);
		}
		return null;
	}
}
