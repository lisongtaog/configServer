package com.bestgo.common.dto;

import java.io.Serializable;

/**
 * MVC层公共返回
 * @author maliang
 */
public class ResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 返回结果code  */
	private String resultCode;	
	/** 返回结果msg  */
	private String resultMsg;
	/** 事务id */
	private String transactionID;
	/** 返回的其他信息  */
	private Object resultObj;
	
	public static ResponseDto instance(Object resultObj){
		return new ResponseDto(resultObj);
	}
	
	private ResponseDto(Object resultObj){
		this.resultCode ="0000";
		this.resultMsg ="成功";
		this.transactionID = "";
		this.resultObj = resultObj;
	}
	public ResponseDto(){}
	public ResponseDto(String resultCode,String resultMsg,Object resultObj){
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultObj = resultObj;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultObj() {
		return resultObj;
	}
	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}	
}
