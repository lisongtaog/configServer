package com.bestgo.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bestgo.common.dto.BaseDto;

public class UtiIUserDto extends BaseDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String userCode;
	/** 属性登陆账号 / */
	private String user_Code;
	/** 属性登陆名称/ */
	private String userName;
	/** 属性业务员代码/ */
	private String salesManCode;
	/** 属性业务员姓名/ */
	private String salesManName;
	/** 属性用户类型/ */
	private String userType;
	/** 属性用户分类/ */
	private String userSort;
	/** 属性所属机构代码/ */
	private String comCode;
	/** 属性最新用户代码/ */
	private String newUserCode;
	/** 属性老用户代码/ */
	private String oldUserCode;
	/** 属性是否为交叉销售用户/ */
	private String crossUserFlag;
	/** 属性漫游分类/ */
	private String roamingType;
	/** 属性漫游状态/ */
	private String roamingStatus;
	/** 属性漫游地/ */
	private String roamComCode;
	/** 属性效力状态/ */
	private String validStatus;
	/** 属性审核状态/ */
	private String auditStatus;
	/** 属性有效终止时间/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date validEndDate;
	/** 属性信息创建日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createDate;
	/** 属性信息创建人员/ */
	private String creatorCode;
	/** 属性最新更新操作日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateDate;
	/** 属性最新更新操作人员/ */
	private String updaterCode;
	/** 属性标志字段/ */
	private String flag;
	/** 用户输入原密码 */
	private String passWord;
	/** 属性userLevel/用户级别(0:管理员，1：高级，2：中级，3：初级 ) */
	private String userLevel;
	/** 属性jobTitle/工作职务 */
	private String jobTitle;
	/** 属性department/部门机构(水险部 M，非水部 P，责任险 L，合约金融 T，创新业务 I,综合管理 R，上海分公司 S) */
	private String department;
	/** 属性businessLevel/业务级别（高级，中级，初级，其他） */
	private String businessLevel;
	/** 属性state/ 人员状态(0：其他，1：在职，2：休假)*/
	private String state;

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUser_Code() {
		return user_Code;
	}

	public void setUser_Code(String user_Code) {
		this.user_Code = user_Code;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserSort() {
		return userSort;
	}

	public void setUserSort(String userSort) {
		this.userSort = userSort;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getNewUserCode() {
		return newUserCode;
	}

	public void setNewUserCode(String newUserCode) {
		this.newUserCode = newUserCode;
	}

	public String getSalesManCode() {
		return salesManCode;
	}

	public void setSalesManCode(String salesManCode) {
		this.salesManCode = salesManCode;
	}

	public String getSalesManName() {
		return salesManName;
	}

	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}

	public String getOldUserCode() {
		return oldUserCode;
	}

	public void setOldUserCode(String oldUserCode) {
		this.oldUserCode = oldUserCode;
	}

	public String getCrossUserFlag() {
		return crossUserFlag;
	}

	public void setCrossUserFlag(String crossUserFlag) {
		this.crossUserFlag = crossUserFlag;
	}

	public String getRoamingType() {
		return roamingType;
	}

	public void setRoamingType(String roamingType) {
		this.roamingType = roamingType;
	}

	public String getRoamingStatus() {
		return roamingStatus;
	}

	public void setRoamingStatus(String roamingStatus) {
		this.roamingStatus = roamingStatus;
	}

	public String getRoamComCode() {
		return roamComCode;
	}

	public void setRoamComCode(String roamComCode) {
		this.roamComCode = roamComCode;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public java.util.Date getValidEndDate() {
		return validEndDate;
	}

	public void setValidEndDate(java.util.Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatorCode() {
		return creatorCode;
	}

	public void setCreatorCode(String creatorCode) {
		this.creatorCode = creatorCode;
	}

	public String getUpdaterCode() {
		return updaterCode;
	}

	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
