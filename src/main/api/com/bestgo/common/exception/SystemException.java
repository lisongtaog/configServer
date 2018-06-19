package com.bestgo.common.exception;

import com.bestgo.common.exception.*;

public class SystemException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public SystemException() {
        super();
    }
	
	public SystemException(String message) {
	    super(BaseException.defaultErrorCode, message);
	}
	
	public SystemException(String code, String message) {
       super(code, message);
    }

	@Override
	public String getCatalogCode() {
		return BaseException.SystemCatalog;
	}

}
