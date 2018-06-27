package com.bestgo.config.dto;

import com.bestgo.common.dto.BaseQueryConditionDto;

import java.io.Serializable;
import java.util.Date;

public class AppPromotionRuleDto extends BaseQueryConditionDto implements Serializable {

    private Integer id;

    private String country;

    private String appPkg;

    private String conditions;

    private Integer priority;

    private String validstatus;

    private String init;

    private Integer popuptimes;

    private String comments;

    private String actionType;

    private String linkUrl;

    private String packageName;

    private String title;

    private String message;

    private String iconUrl;

    private String bigImageUrl;

    private String nativeImageUrl;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAppPkg() {
        return appPkg;
    }

    public void setAppPkg(String appPkg) {
        this.appPkg = appPkg == null ? null : appPkg.trim();
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Integer getPopuptimes() {
        return popuptimes;
    }

    public void setPopuptimes(Integer popuptimes) {
        this.popuptimes = popuptimes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl == null ? null : bigImageUrl.trim();
    }

    public String getNativeImageUrl() {
        return nativeImageUrl;
    }

    public void setNativeImageUrl(String nativeImageUrl) {
        this.nativeImageUrl = nativeImageUrl == null ? null : nativeImageUrl.trim();
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