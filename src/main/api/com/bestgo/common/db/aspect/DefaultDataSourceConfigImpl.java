package com.bestgo.common.db.aspect;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

import com.bestgo.common.db.annotation.DataSource;

/**
 * 从静态Map中获取数据源配置文件
 * @author Administrator
 *
 */
public class DefaultDataSourceConfigImpl implements DataSourceConfig{
	
	private Map<String,String> methodMap = new LinkedHashMap<String,String>();
	public Map<String,String> getMethodMap() {
		return methodMap;
	}
	public void setMethodMap(Map<String,String> methodMap) {
		this.methodMap = methodMap;
	}

	public String getDataSourceName(Method m) {
		DataSource data  = null;
		if (m != null && m.isAnnotationPresent(DataSource.class)) {
			data = m.getAnnotation(DataSource.class);
		}	
		if(null!=data&&null!=data.value()){//优先使用方法注解上的数据源配置
			return data.value();
		}

		String className = m.getDeclaringClass().getName();
		className = StringUtils.replace(className, ".", "/");
		AntPathMatcher matcher = new AntPathMatcher();
		
		Set<String> keySet =  methodMap.keySet();
		for(String key:keySet){
			
			String matchMName = key;
			//匹配类路径
			if(key.indexOf("#") > -1){
				String pattern = StringUtils.substringBeforeLast(key, "#");
				pattern = StringUtils.replace(pattern, ".", "/");
				if(!matcher.match(pattern, className)){
					continue;
				}
				
				matchMName = StringUtils.substringAfterLast(key, "#");
			}
			
			//匹配方法名
			if(m.getName().startsWith(matchMName)){
				return (String) methodMap.get(key);
			}
		}
		return null;
	}
	
/*	public static void main(String[] args){
		Class<?>[] types = {};
		try {
			Method m = DataSourcesTestServiceSpringImpl.class.getMethod("methodA", null);
			HashMapDataSourceConfigImpl config = new HashMapDataSourceConfigImpl();
			System.out.println("name="+config.getDataSourceName(m));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}*/
}
