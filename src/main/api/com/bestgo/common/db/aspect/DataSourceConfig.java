package com.bestgo.common.db.aspect;

import java.lang.reflect.Method;

/**
 * 根据方法及方法注解获取
 * @author Administrator
 *
 */
public interface DataSourceConfig {
	/**
	 * 根据方法获取动态数据源配置,如查询不到返回空
	 * @param m 执行的方法
	 * @return
	 */
	public String getDataSourceName(Method m); 
}
