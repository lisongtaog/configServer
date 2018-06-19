package com.bestgo.common.exception;

import com.bestgo.common.exception.*;

public class ExecuteLimitException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExecuteLimitException(String code,String msg){
		super(code,msg);
	}

	@Override
	public String getCatalogCode() {
		return BaseException.SystemCatalog;
	}

}
