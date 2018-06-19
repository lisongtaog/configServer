package com.bestgo.common.db.aspect;

import java.lang.reflect.Method;
import java.util.Stack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.bestgo.common.db.datasource.DataSources;
import com.bestgo.common.db.datasource.DynamicDataSourceHolder;

@Order(-1)
public class DataSourceAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

	private DataSources dataSources;
	
	private DataSourceConfig dataSourceConfig;
	
	//private static final Stack<String> stack = new Stack<String>();
	
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		
		Stack<String> stack = new Stack<String>();
		Object resultObj = null;
		
		Object target = jp.getTarget();
		String method = jp.getSignature().getName();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) jp.getSignature()).getMethod().getParameterTypes();
		Method m = null;
		
		try {
			m = classz.getMethod(method, parameterTypes);
			
			beforeMethod(target,m,stack);
			
			resultObj = jp.proceed();
			
			afterMethod(target,m,stack);
		} catch (Throwable e) {
			LOGGER.error("切换动态数据源异常",e);
			afterMethod(target,m,stack);
			throw e;
		}
		
		return resultObj;
	}
	
	
	public void beforeMethod(Object target,Method m,Stack<String> stack) throws Exception {

		try {
			String dataSourceName = dataSourceConfig.getDataSourceName(m);
			String lastDataSource = DynamicDataSourceHolder.getDataSouce();
			LOGGER.debug("方法[{}]开始执行数据源切换,当前线程数据源名称:{},方法指定数据源类型:{}",m.getName(),lastDataSource,dataSourceName);
			if(lastDataSource != null){
				stack.push(lastDataSource);
				LOGGER.debug("当前线程数据源已存入记录器:{}",lastDataSource);
				if(dataSourceName == null){
					LOGGER.debug("当前线程数据源不为空，且方法未指定数据源，使用当前数据源:{}",lastDataSource);
					DynamicDataSourceHolder.putDataSource(lastDataSource);
					stack.push(lastDataSource);
					LOGGER.debug("当前方法数据源已存入记录器：{}",lastDataSource);
					LOGGER.debug("方法[{}]完成数据源切换",m.getName());
					return;
				}
			}else{
				LOGGER.debug("当前线程未检测到已存在的数据源");
			}
			
			if (dataSourceName == null) {
				String[] sources = dataSources.getDataSources().get("master");
				int random = (int) (Math.random() * sources.length);
				DynamicDataSourceHolder.putDataSource(sources[random]);
				LOGGER.debug("当前线程数据源为空，且方法未指定数据源，使用默认数据源:{}",sources[random]);
				stack.push(sources[random]);
				LOGGER.debug("当前方法数据源已存入记录器：{}",sources[random]);
			} else {
				String[] sources = dataSources.getDataSources().get(dataSourceName);
				if (sources == null || sources.length == 0) {
					String[] masterSources = dataSources.getDataSources().get("master");
					int random = (int) (Math.random() * masterSources.length);
					DynamicDataSourceHolder.putDataSource(masterSources[random]);
					LOGGER.debug("方法指定数据源类型{}未找到数据源，使用默认数据源:{}",dataSourceName,masterSources[random]);
					stack.push(masterSources[random]);
					LOGGER.debug("当前方法数据源已存入记录器：{}",masterSources[random]);
				} else {
					int random = (int) (Math.random() * sources.length);
					DynamicDataSourceHolder.putDataSource(sources[random]);
					LOGGER.debug("方法指定数据源类型{}找到数据源，使用数据源:{}",dataSourceName,sources[random]);
					stack.push(sources[random]);
					LOGGER.debug("当前方法数据源已存入记录器：{}",sources[random]);
				}
			}
			
			LOGGER.debug("方法[{}]完成数据源切换",m.getName());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			throw e;
		}
	}
	
	public void afterMethod(Object target,Method m,Stack<String> stack) {

		try {
			if(m != null){
				LOGGER.debug("方法[{}]开始数据源恢复",m.getName());
				if(!stack.isEmpty()){
					String dsName = stack.pop();
					LOGGER.debug("当前方法数据源已从记录器清除：{}",dsName);
				}
				if(!stack.isEmpty()) {
					String dsName = stack.pop();
					LOGGER.debug("当前线程原数据源已从记录器清除:{}",dsName);
					DynamicDataSourceHolder.putDataSource(dsName);
					LOGGER.debug("线程数据源已切换回原数据源:{}",dsName);
				} else {
					DynamicDataSourceHolder.putDataSource(null);
					LOGGER.debug("线程数据源已切换为空");
				}
				LOGGER.debug("方法[{}]完成数据源恢复",m.getName());
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			throw e;
		}
	}
	

	/*public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();
		
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz.getMethod(method, parameterTypes);

			String dataSourceName = dataSourceConfig.getDataSourceName(m);
			String lastDataSource = DynamicDataSourceHolder.getDataSouce();
			LOGGER.debug("方法[{}]开始执行数据源切换,当前线程数据源名称:{},方法指定数据源类型:{}",m.getName(),lastDataSource,dataSourceName);
			if(lastDataSource != null){
				stack.push(lastDataSource);
				LOGGER.debug("当前线程数据源已存入记录器:{}",lastDataSource);
				if(dataSourceName == null){
					LOGGER.debug("当前线程数据源不为空，且方法未指定数据源，使用当前数据源:{}",lastDataSource);
					DynamicDataSourceHolder.putDataSource(lastDataSource);
					stack.push(lastDataSource);
					LOGGER.debug("当前方法数据源已存入记录器：{}",lastDataSource);
					return;
				}
			}else{
				LOGGER.debug("当前线程未检测到已存在的数据源");
			}
			if (dataSourceName == null) {
				String[] sources = dataSources.getDataSources().get("master");
				int random = (int) (Math.random() * sources.length);
				DynamicDataSourceHolder.putDataSource(sources[random]);
				LOGGER.debug("当前线程数据源为空，且方法未指定数据源，使用默认数据源:{}",sources[random]);
				stack.push(sources[random]);
				LOGGER.debug("当前方法数据源已存入记录器：{}",sources[random]);
			} else {
				String[] sources = dataSources.getDataSources().get(dataSourceName);
				if (sources == null || sources.length == 0) {
					String[] masterSources = dataSources.getDataSources().get("master");
					int random = (int) (Math.random() * masterSources.length);
					DynamicDataSourceHolder.putDataSource(masterSources[random]);
					LOGGER.debug("方法指定数据源类型{}未找到数据源，使用默认数据源:{}",dataSourceName,masterSources[random]);
					stack.push(masterSources[random]);
					LOGGER.debug("当前方法数据源已存入记录器：{}",masterSources[random]);
				} else {
					int random = (int) (Math.random() * sources.length);
					DynamicDataSourceHolder.putDataSource(sources[random]);
					LOGGER.debug("方法指定数据源类型{}找到数据源，使用数据源:{}",dataSourceName,sources[random]);
					stack.push(sources[random]);
					LOGGER.debug("当前方法数据源已存入记录器：{}",sources[random]);
				}
			}
			
			LOGGER.debug("方法[{}]完成数据源切换",m.getName());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);			
		}
	}*/
	


	/*public void after(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();

		//Class<?>[] classz = target.getClass().getInterfaces();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz.getMethod(method, parameterTypes);
			if(m != null && m.isAnnotationPresent(DataSource.class)){
				LOGGER.debug("方法[{}]开始数据源恢复",m.getName());
				if(!stack.isEmpty()){
					String dsName = stack.pop();
					LOGGER.debug("当前方法数据源已从记录器清除：{}",dsName);
				}
				if(!stack.isEmpty()) {
					String dsName = stack.pop();
					LOGGER.debug("当前线程原数据源已从记录器清除:{}",dsName);
					DynamicDataSourceHolder.putDataSource(dsName);
					LOGGER.debug("线程数据源已切换回原数据源:{}",dsName);
				} else {
					DynamicDataSourceHolder.putDataSource(null);
					LOGGER.debug("线程数据源已切换为空");
				}
				LOGGER.debug("方法[{}]完成数据源恢复",m.getName());
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
	}*/

	public void setDataSources(DataSources dataSources) {
		this.dataSources = dataSources;
	}

	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
		this.dataSourceConfig = dataSourceConfig;
	}
}
