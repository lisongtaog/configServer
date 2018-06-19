package com.bestgo.user.entity;

/**
 * @author codegen@研发中心
 * 账户表-UtiIAccount 主键操作类
 */
public class UtiIAccountKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public UtiIAccountKey(String accCode) {
		this.accCode = accCode;
	}

	/** 属性账号代码/ */
	private String accCode ;
	/**
	 * 属性账号代码/的getter方法
	 */
	public String getAccCode() {
		return accCode;
	}
	/**
	 * 属性账号代码/的setter方法
	 */
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	} 
}