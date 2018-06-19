package com.bestgo.common.exception;

import com.bestgo.common.exception.*;

/**
 * @description 自定义数据校验异常类
 */
public class DataVerifyException extends BaseException {
    private static final long serialVersionUID = 1L;
    //通用业务异常code
    public static final String DATAVERIFY_ERROR_CODE = "9999";

    public DataVerifyException() {
        super();
    }
    
    public DataVerifyException(String message) {
        super(DATAVERIFY_ERROR_CODE, message);
    }
    
    public DataVerifyException(String code, String message) {
       super(code, message);
    }

	@Override
	public String getCatalogCode() {
		return BaseException.DataVerifyCatalog;
	}
}
