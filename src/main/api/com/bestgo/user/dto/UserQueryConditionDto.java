package com.bestgo.user.dto;

import com.bestgo.common.dto.BaseQueryConditionDto;

/**
 * @description 用户查询条件对象
 * @author chengzhuo
 * @data 2016/9/14 16:30
 *
 */
public class UserQueryConditionDto extends BaseQueryConditionDto implements java.io.Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**登陆账号*/
	private String userCode;
	/**业务人员姓名*/
	private String salesManName;
	/**所属省级机构*/
	private String proviceComCode;
	/**所属分支机构*/
	private String cityComCode;
	/**所属总公司*/
	private String headComCode;
	/**所属机构*/
	private String comCode;
	
	private String validStatus;
	
	/** 属性userName/员工姓名 */
	private String userName;
	/** 属性department/部门机构 */
	private String department;
	/** 属性nation/籍贯 */
	private String nation;
	/** 属性jobTitle/工作职务 */
	private String jobTitle;
	/** 属性state/人员状态 */
	private String state;
	/** 属性qualificationFlag/是否具有经纪人资格证 */
	private String qualificationFlag;
	/** 属性education/最高学历(0：其他，1：高中，2：大专，3：本科，4：研究生，5：博士，6：博士后) */
	private String education;
	/** 属性contractStratDate/合同日期始 */
	private String contractStratDate;
	/** 属性contractEndDate/合同日期终 */
	private String contractEndDate;
	/** 属性userLevel/用户级别 */
	private String userLevel;
	/** 属性办公电话号码/ */
	private String officePhone ;
	/** 属性传真号码/ */
	private String faxNumber ;
	/** 属性手机号码/ */
	private String mobile ;
	/** 属性邮件地址/ */
	private String email ;
	/** 属性classCode/险类代码 */
	private String classCode ;
	/** 属性className/险类名称 */
	private String className ;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSalesManName() {
		return salesManName;
	}

	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}

	public String getProviceComCode() {
		return proviceComCode;
	}

	public void setProviceComCode(String proviceComCode) {
		this.proviceComCode = proviceComCode;
	}

	public String getCityComCode() {
		return cityComCode;
	}

	public void setCityComCode(String cityComCode) {
		this.cityComCode = cityComCode;
	}

	public String getHeadComCode() {
		return headComCode;
	}

	public void setHeadComCode(String headComCode) {
		this.headComCode = headComCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

    public String getValidStatus()
    {
        return validStatus;
    }

    public void setValidStatus(String validStatus)
    {
        this.validStatus = validStatus;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getQualificationFlag() {
		return qualificationFlag;
	}

	public void setQualificationFlag(String qualificationFlag) {
		this.qualificationFlag = qualificationFlag;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getContractStratDate() {
		return contractStratDate;
	}

	public void setContractStratDate(String contractStratDate) {
		this.contractStratDate = contractStratDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
