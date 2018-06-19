package com.bestgo.common.exception;

import com.bestgo.common.exception.*;

/**
 * @description  自定义业务异常类
 * @author maliang
 */
public class BusinessException extends BaseException {
	private static final long serialVersionUID = 1L;
    //通用业务异常code
	public static final String BUSINESS_ERROR_CODE = "9999";

	public BusinessException() {
        super();
    }
	
	public BusinessException(String message) {
	       super(BUSINESS_ERROR_CODE, message);
	}
	
	public BusinessException(String code, String message) {
       super(code, message);
    }

	@Override
	public String getCatalogCode() {
		return BaseException.BusinessCatalog;
	}

}