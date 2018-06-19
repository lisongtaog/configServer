package com.bestgo.common.exception;

/**
 * @description  基础异常类
 * @author maliang
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public static final String PermissionCatalog = "1";
    public static final String DataVerifyCatalog = "2";
    public static final String BusinessCatalog   = "3";
    public static final String SystemCatalog     = "4";
    public static final String OtherCatalog      = "9";
    
    public static final String defaultErrorCode  = "9999";
    
    /*
     * 自定义异常代码
     */
	private String code;
	/*
	 * 自定义异常信息
	 */
	private String message;
	
	public BaseException(String code, String message){
	    this.code = (code==null?defaultErrorCode:code);
	    this.message = message;
	}
	
	public abstract String getCatalogCode();

    public String getMessage()
    {
        return message;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

}
