package com.bestgo.user.entity;

public class UtiIUser extends UtiIUserKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性登陆名称/ */
	private String userName ;
	/** 属性业务员代码/ */
	private String salesManCode ;
	/** 属性业务员姓名/ */
	private String salesManName ;
	/** 属性用户类型/ */
	private String userType ;
	/** 属性用户分类/ */
	private String userSort ;
	/** 属性所属机构代码/ */
	private String comCode ;
	/** 属性最新用户代码/ */
	private String newUserCode ;
	/** 属性老用户代码/ */
	private String oldUserCode ;
	/** 属性是否为交叉销售用户/ */
	private String crossUserFlag ;
	/** 属性漫游分类/ */
	private String roamingType ;
	/** 属性漫游状态/ */
	private String roamingStatus ;
	/** 属性漫游地/ */
	private String roamComCode ;
	/** 属性效力状态/ */
	private String validStatus ;
	/** 属性审核状态/ */
	private String auditStatus ;
	/** 属性有效终止时间/ */
	private java.util.Date validEndDate ;
	/** 属性信息创建日期/ */
	private java.util.Date createDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	private java.util.Date updateDate ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性标志字段/ */
	private String flag ;
	/** 属性userLevel/用户级别(0:管理员，1：高级，2：中级，3：初级  ) */
	private String userLevel ;
	/** 属性jobTitle/工作职务 */
	private String jobTitle ;
	/** 属性department/部门机构(水险部 M，非水部 P，责任险 L，合约金融 T，创新业务 I,综合管理 R，上海分公司 S) */
	private String department ;
	/** 属性businessLevel/业务级别（高级，中级，初级，其他） */
	private String businessLevel ;
	/** 属性state/人员状态(0：其他，1：在职，2：休假) */
	private String state ;
	
	/**
	 * 类UtiIUser的默认构造方法
	 */
	public UtiIUser() {
	}

	/**
	 * 属性登陆名称/的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性登陆名称/的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	} 
	/**
	 * 属性业务员代码/的getter方法
	 */
	public String getSalesManCode() {
		return salesManCode;
	}
	/**
	 * 属性业务员代码/的setter方法
	 */
	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	} 
	/**
	 * 属性业务员姓名/的getter方法
	 */
	public String getSalesManName() {
		return salesManName;
	}
	/**
	 * 属性业务员姓名/的setter方法
	 */
	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	} 
	/**
	 * 属性用户类型/的getter方法
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 属性用户类型/的setter方法
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	} 
	/**
	 * 属性用户分类/的getter方法
	 */
	public String getUserSort() {
		return userSort;
	}
	/**
	 * 属性用户分类/的setter方法
	 */
	public void setUserSort(String userSort) {
		this.userSort = userSort;
	} 
	/**
	 * 属性所属机构代码/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性所属机构代码/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性最新用户代码/的getter方法
	 */
	public String getNewUserCode() {
		return newUserCode;
	}
	/**
	 * 属性最新用户代码/的setter方法
	 */
	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	} 
	/**
	 * 属性老用户代码/的getter方法
	 */
	public String getOldUserCode() {
		return oldUserCode;
	}
	/**
	 * 属性老用户代码/的setter方法
	 */
	public void setOldUserCode(String oldUserCode) {
		this.oldUserCode = oldUserCode;
	} 
	/**
	 * 属性是否为交叉销售用户/的getter方法
	 */
	public String getCrossUserFlag() {
		return crossUserFlag;
	}
	/**
	 * 属性是否为交叉销售用户/的setter方法
	 */
	public void setCrossUserFlag(String crossUserFlag) {
		this.crossUserFlag = crossUserFlag;
	} 
	/**
	 * 属性漫游分类/的getter方法
	 */
	public String getRoamingType() {
		return roamingType;
	}
	/**
	 * 属性漫游分类/的setter方法
	 */
	public void setRoamingType(String roamingType) {
		this.roamingType = roamingType;
	} 
	/**
	 * 属性漫游状态/的getter方法
	 */
	public String getRoamingStatus() {
		return roamingStatus;
	}
	/**
	 * 属性漫游状态/的setter方法
	 */
	public void setRoamingStatus(String roamingStatus) {
		this.roamingStatus = roamingStatus;
	} 
	/**
	 * 属性漫游地/的getter方法
	 */
	public String getRoamComCode() {
		return roamComCode;
	}
	/**
	 * 属性漫游地/的setter方法
	 */
	public void setRoamComCode(String roamComCode) {
		this.roamComCode = roamComCode;
	} 
	/**
	 * 属性效力状态/的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态/的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 
	/**
	 * 属性审核状态/的getter方法
	 */
	public String getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 属性审核状态/的setter方法
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	} 
	/**
	 * 属性有效终止时间/的getter方法
	 */
	public java.util.Date getValidEndDate() {
		return validEndDate;
	}
	/**
	 * 属性有效终止时间/的setter方法
	 */
	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	} 
	/**
	 * 属性信息创建日期/的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性信息创建日期/的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	} 
	/**
	 * 属性信息创建人员/的getter方法
	 */
	public String getCreatorCode() {
		return creatorCode;
	}
	/**
	 * 属性信息创建人员/的setter方法
	 */
	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	} 
	/**
	 * 属性最新更新操作日期/的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性最新更新操作日期/的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 
	/**
	 * 属性最新更新操作人员/的getter方法
	 */
	public String getUpdaterCode() {
		return updaterCode;
	}
	/**
	 * 属性最新更新操作人员/的setter方法
	 */
	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	} 
	/**
	 * 属性标志字段/的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBusinessLevel() {
		return businessLevel;
	}

	public void setBusinessLevel(String businessLevel) {
		this.businessLevel = businessLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	} 
	
}