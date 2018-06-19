package com.bestgo.common.exception;

import com.bestgo.common.exception.*;

/**
 * @description  自定义权限异常类
 * @author maliang
 */
public class PermissionException extends BaseException {
	private static final long serialVersionUID = 1L;
	//通用业务异常code
    public static final String PERMISSION_ERROR_CODE = "9999";
    
    private String taskName;

    public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public PermissionException() {
        super();
    }
    
    public PermissionException(String message) {
        super(null, message);
    }
    
    public PermissionException(String code, String message) {
       super(code, message);
    }

	@Override
	public String getCatalogCode() {
		return BaseException.PermissionCatalog;
	}

}