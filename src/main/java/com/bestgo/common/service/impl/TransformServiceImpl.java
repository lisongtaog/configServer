package com.bestgo.common.service.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestgo.common.service.TransformService;
import com.bestgo.common.util.ReflectUtil;
import com.bestgo.common.util.transform.Trans;
import com.bestgo.common.util.transform.TransfromInter;
/**
 * 代码转换的服务实现类
 */
public class TransformServiceImpl implements TransformService{    
	private static Logger LOGGER = LoggerFactory.getLogger(TransformServiceImpl.class);
	
	/**
	 * 实际进行翻译的工具类
	 */
	private TransfromInter  transTool = null;	
	public void setTransTool(TransfromInter transTool) {
		this.transTool = transTool;
	}
	public TransfromInter getTransTool() {
		return transTool;
	}
	/**
	 * 代码转服务
	 */
	public void trasnObject(Object obj) {
		if(null==obj||null==transTool){
			return;
		}		
		if(Iterable.class.isAssignableFrom(obj.getClass())){//说明是List
			Iterable iter = (Iterable)obj;				
			Iterator<Object> it = iter.iterator(); 
	        while(it.hasNext()){  
	        	trasnObject(it.next());
	        }
	        return;
	    }
		Field[] fields =  obj.getClass().getDeclaredFields();
		for(Field f:fields){
			//获取注解值					
			Object srcVal = ReflectUtil.getFieldValue(obj, f.getName(), f.getType());
			if(null!=srcVal){
				if(Iterable.class.isAssignableFrom(f.getType())){//说明是List
					Iterable iter = (Iterable)srcVal;				
					Iterator<Object> it = iter.iterator(); 
			        while(it.hasNext()){  
			        	trasnObject(it.next());
			        }  			
				}else if(Map.class.isAssignableFrom(f.getType())){//说明是Map
					Map map = (Map) srcVal;
					Iterator<String> iterator = map.keySet().iterator();  
			        while(iterator.hasNext()){  
			            String key = iterator.next();  
			            trasnObject(map.get(key));
			        }  		
				}else if(f.getType().isArray()){//说明是数组
					Object[] iter = (Object[])srcVal;
					if(null!=iter&&iter.length>0){
						for(Object item:iter){
							trasnObject(item);
						}
					}
				}else{
					//判断注解类型
					Annotation annotation = f.getAnnotation(Trans.class);
					if(null!=annotation){
						Trans transAnnotation = (Trans)annotation;
						try {
							String codeType = transAnnotation.codeType();
							String targetPropertyName = transAnnotation.targetProperty();
							Object targetVal = transTool.transVal(codeType, srcVal);
							//判断是否有目标值
							if(null!=targetPropertyName&&!"".equals(targetPropertyName)){
								setBeanVal(obj,targetPropertyName,targetVal);
							}else{
								ReflectUtil.setFieldValue(obj, f.getName(), f.getType(), targetVal);
							}				
						} catch (Exception e) {
							e.printStackTrace();
						}
					}					
				}				
			}
		}		
	}
	private void setBeanVal(Object obj, String targetPropertyName, Object targetVal) {
		Field[] fields =  obj.getClass().getDeclaredFields();
		try {
			for(Field f:fields){
				if(f.getName().equals(targetPropertyName)){
					ReflectUtil.setFieldValue(obj, f.getName(), f.getType(), targetVal);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
