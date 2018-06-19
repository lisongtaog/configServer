package com.bestgo.user.entity;

/**
 * UtiIUser的主键
 */
public class UtiIUserKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public UtiIUserKey(){}
	public UtiIUserKey(String userCode){
		this.userCode = userCode;
	}
	/** 属性登陆账号/ */
	private String userCode ;
	/**
	 * 属性登陆账号/的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性登陆账号/的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 
}