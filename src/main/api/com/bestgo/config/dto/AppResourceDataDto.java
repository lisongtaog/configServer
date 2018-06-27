package com.bestgo.config.dto;

import com.bestgo.common.dto.BaseQueryConditionDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AppResourceDataDto extends BaseQueryConditionDto implements Serializable {

    private static final long serialVersionUID = 4550212304545441640L;
    private Integer id;

    private String appType;

    private String country;

    private String appId;

    private String appPkg;
    /**app应用包资源集合*/
    private List<String> appResource;

    private String appName;

    private String validstatus;

    private String init;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppPkg() {
        return appPkg;
    }

    public void setAppPkg(String appPkg) {
        this.appPkg = appPkg == null ? null : appPkg.trim();
    }

    public List<String> getAppResource() {
        return appResource;
    }

    public void setAppResource(List<String> appResource) {
        this.appResource = appResource;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getValidstatus() {
        return validstatus;
    }

    public void setValidstatus(String validstatus) {
        this.validstatus = validstatus == null ? null : validstatus.trim();
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init == null ? null : init.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}