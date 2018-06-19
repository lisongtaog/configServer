package com.bestgo.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bestgo.common.dto.BaseDto;

public class UserDto extends BaseDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性登陆账号 / */
	private String userCode;
	/** 属性登陆名称/ */
	private String userName ;
	/** 属性用户类型/ */
	private String userType ;
	/** 属性用户分类/ */
	private String userSort ;
	/** 属性所属机构代码/ */
	private String comCode ;
	/** 属性效力状态/ */
	private String validStatus ;
	/** 属性审核状态/ */
	private String auditStatus ;
	/** 属性有效终止时间/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date validEndDate ;
	/** 属性信息创建日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createDate ;
	/** 属性信息创建人员/ */
	private String creatorCode ;
	/** 属性最新更新操作日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateDate ;
	/** 属性最新更新操作人员/ */
	private String updaterCode ;
	/** 属性marriage/婚姻状态(0：其他，1：已婚，2、未婚，3：离异) */
	private String marriage ;
	/** 属性graduateSchool/毕业院校 */
	private String graduateSchool ;
	/** 属性professional/毕业专业 */
	private String professional ;
	/** 属性nationality/民族 */
	private String nationality ;
	/** 属性nation/籍贯 */
	private String nation ;
	/** 属性province/省/直辖市 */
	private String province ;
	/** 属性residenceAddr/户口所在地 */
	private String residenceAddr ;
	/** 属性politicalState/政治面貌（0：其他，1：无党派，2：团员，3：党员） */
	/** 属性标志字段/ */
	private String flag ;
	/**用户输入新密码*/
	private String newPassword;
	/**账号代码*/
	private String accCode ;
	/** 属性服务代码/ */
	private String svrCode ;
	/** 属性账号名称/ */
	private String accName ;
	/** 属性账号密码/ */
	private String passWord ;
	/** 属性原系统账号代码/ */
	private String fAccCode ;
	/** 属性服务名称/ */
	private String svrName ;
	
	private String loginPowerFlag ;
	/** 属性密码设定日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date passwdSetDate ;
	/** 属性密码过期日期/ */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date passwdExpireDate ;
	/** 属性归属保险公司(保险公司总级)/ */
	private String headComCode ;
	/** 属性所属保险公司省级代码/ */
	private String proviceComCode ;
	/** 属性所属保险公司分支机构代码/ */
	private String cityComCode ;
	/** 属性所属保险公司分支机构名称/ */
	private String cityComName ;
	/** 属性证件类型/ */
	private String identityType ;
	/** 属性是否允许修改初始密码标识0不允许1允许/ */
	private String modifyPasswdFlag ;
	/**属性是否是总公司0不是1是*/
	private String shareFlag;
	/** 属性接收初始密码邮箱/ */
	private String receivePwEMail ;
	/** 属性家里电话号码/ */
	private String homePhone ;
	/** 属性办公电话号码/ */
	private String officePhone ;
	/** 属性传真号码/ */
	private String faxNumber ;
	/** 属性手机号码/ */
	private String mobile ;
	/** 属性邮件地址/ */
	private String email ;
	/** 属性邮箱密码 */
	private String emailPsw;
	/** 属性邮寄地址/ */
	private String postAddress ;
	/** 属性邮政编码/ */
	private String postCode ;
	/** 属性地址中文名称/ */
	private String addressCName ;
	/** 属性地址英文名称/ */
	private String addressEName ;
	/** 属性个人身份证件号码/ */
	private String identifyNumber ;
	/** 属性性别/ */
	private String sex ;
	/** 属性出生日期/ */
	@JsonFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthDate ;
	/** 属性年龄/ */
	private String age ;
	/** 属性健康状况/ */
	private String health ;

	public String getShareFlag() {
		return shareFlag;
	}
	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
	}
	public String getUserCode()
    {
        return userCode;
    }
    public void setUserCode(String userCode)
    {
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public String getSvrCode() {
		return svrCode;
	}
	public void setSvrCode(String svrCode) {
		this.svrCode = svrCode;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getfAccCode() {
		return fAccCode;
	}
	public void setfAccCode(String fAccCode) {
		this.fAccCode = fAccCode;
	}
	public String getSvrName() {
		return svrName;
	}
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	}
	public String getLoginPowerFlag() {
		return loginPowerFlag;
	}
	public void setLoginPowerFlag(String loginPowerFlag) {
		this.loginPowerFlag = loginPowerFlag;
	}
	public java.util.Date getPasswdSetDate() {
		return passwdSetDate;
	}
	public void setPasswdSetDate(java.util.Date passwdSetDate) {
		this.passwdSetDate = passwdSetDate;
	}
	public java.util.Date getPasswdExpireDate() {
		return passwdExpireDate;
	}
	public void setPasswdExpireDate(java.util.Date passwdExpireDate) {
		this.passwdExpireDate = passwdExpireDate;
	}
	public String getHeadComCode() {
		return headComCode;
	}
	public void setHeadComCode(String headComCode) {
		this.headComCode = headComCode;
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
	public String getCityComName() {
		return cityComName;
	}
	public void setCityComName(String cityComName) {
		this.cityComName = cityComName;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getModifyPasswdFlag() {
		return modifyPasswdFlag;
	}
	public void setModifyPasswdFlag(String modifyPasswdFlag) {
		this.modifyPasswdFlag = modifyPasswdFlag;
	}
	public String getReceivePwEMail() {
		return receivePwEMail;
	}
	public void setReceivePwEMail(String receivePwEMail) {
		this.receivePwEMail = receivePwEMail;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
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
	public String getEmailPsw() {
		return emailPsw;
	}
	public void setEmailPsw(String emailPsw) {
		this.emailPsw = emailPsw;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddressCName() {
		return addressCName;
	}
	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}
	public String getAddressEName() {
		return addressEName;
	}
	public void setAddressEName(String addressEName) {
		this.addressEName = addressEName;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getResidenceAddr() {
		return residenceAddr;
	}
	public void setResidenceAddr(String residenceAddr) {
		this.residenceAddr = residenceAddr;
	}

}
