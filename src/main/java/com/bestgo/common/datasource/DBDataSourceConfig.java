package com.bestgo.common.datasource;

import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Resource;

import com.bestgo.common.db.aspect.DataSourceConfig;
import com.bestgo.common.service.CodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import com.bestgo.common.db.annotation.DataSource;
import com.bestgo.common.db.aspect.DataSourceConfig;
import com.bestgo.common.exception.SystemException;

public class DBDataSourceConfig implements DataSourceConfig {
	
	/*@Resource
	private CodeService codeService;*/

	@Override
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
		
		/*NewCodeQueryConditionDto newCodeQueryConditionDto = new NewCodeQueryConditionDto();
		newCodeQueryConditionDto.setCodeType("dataSourceConfig");
		List<PrpDNewCodeDto> methodList = null;
		try{
			methodList = codeService.queryNewcodeListByLike(newCodeQueryConditionDto);
		}catch(RpcException re){
			throw new SystemException("4101","查询动态数据源配置");
		}
		
		for(PrpDNewCodeDto method :methodList){
			String key = method.getCodeCode();
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
				return method.getCodeCName();
			}
		}*/
		return null;
	}

}
