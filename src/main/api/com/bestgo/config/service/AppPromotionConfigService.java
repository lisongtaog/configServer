package com.bestgo.config.service;

import com.bestgo.common.dto.PageInfo;
import com.bestgo.config.dto.AppPromotionRuleDto;
import com.bestgo.config.dto.AppResourceDataDto;

import java.util.List;

/**
 * Desc: 广告互推 推广配置服务接口
 * Auth: maliang
 * Date: 2018/6/20 11:28
 */
public interface AppPromotionConfigService {

    /**
     * 查询指定app的配置推广规则
     * @param country   国家
     * @param appPkg    应用包名
     * @return
     */
    public List queryRules(String country,String appPkg);
    /**
     * 查询app资源
     * @param country   国家
     * @param appPkg    应用包名
     * @return
     */
    public List queryAppResources(String country,String appPkg);

    /**
     * 重新全量加载配置数据
     */
    public void reloadResourceANDRule();

    /**
     * 增量刷新、配置 appPkg资源信息
     */
    public void incrResource();

    /**
     *  增量刷新、配置 规则信息
     */
    public void incrRule();
    /**
     * 添加规则
     * @param ruleDto
     */
    public void addAppRule(AppPromotionRuleDto ruleDto);

    /**
     * 添加app资源
     * @param resourceDataDto
     */
    public void addAppResource(AppResourceDataDto resourceDataDto);

    /**
     * 查询配置推广规则（页面）
     * @param ruleDto    规则信息条件
     * @return
     */
    public PageInfo listAppRules(AppPromotionRuleDto ruleDto);
    /**
     * 查询app资源（页面）
     * @param resourceDataDto    应用资源信息条件
     * @return
     */
    public PageInfo listAppResources(AppResourceDataDto resourceDataDto);

    public void deleteResource(int id);
    public void deleteRule(int id);

    int updateAppResource(AppResourceDataDto appResourceDataDto);

    int updateAppRule(AppPromotionRuleDto appPromotionRuleDto);
}
