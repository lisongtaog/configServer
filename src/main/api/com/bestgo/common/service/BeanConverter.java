package com.bestgo.common.service;

import java.util.Collection;
import java.util.List;

/**
 * 对象转换工具类
 * @author 
 * 
 */
public interface BeanConverter {
	/**
	 * 转换对象
	 * @param src 源对象
	 * @param des 目标对象
	 */
	public void convert(Object src, Object des);
	/**
	 * 转换对象
	 * @param src 源对象
	 * @param des 目标对象
	 * @param mapId 模板ID
	 */	
    public void convert(Object src, Object des, String mapId);
	/**
	 * 转换对象
	 * @param src 源对象
	 * @param desClass 目标对象Class
	 * @param mapId 模板ID
	 * @return descObj 返回目标对象
	 */	  
    public <T> T convert(Object src, Class<T> desClass, String mapId);
	/**
	 * 转换对象
	 * @param src 源对象
	 * @param desClass 目标对象Class
	 * @return descObj 返回目标对象
	 */	    
    public <T> T convert(Object src, Class<T> desClass);
    
    /**
     * list集合转换对象
     * @param sourceList
     * @param desClass
     * @return
     */
    public <T> List<T> convertList(Collection sourceList, Class<T> desClass);
    
    /**
     * list集合转换对象
     * @param sourceList
     * @param destList
     * @param desClass
     * @return
     */
    public <T>void convertList(Collection sourceList, Collection destList, Class<T> desClass);
}
