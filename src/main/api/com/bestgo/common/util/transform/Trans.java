package com.bestgo.common.util.transform;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
/**
 * 转换用注解 codeType为转换类型 
 * @author yangqunwei@sinosoft.com.cn
 * @date  2016-10-09 18:24
 */
public @interface Trans {
	/**
	 * 代码类型
	 * @return
	 */
	String codeType();
	/**
	 * 目标属性
	 * @return
	 */
	String targetProperty() default ""; 
	/**
	 * 返回属性 全称、简称标识
	 * @return
	 */
	boolean shortFlag() default false;
}
