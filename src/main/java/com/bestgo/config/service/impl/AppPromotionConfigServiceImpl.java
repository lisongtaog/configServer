package com.bestgo.config.service.impl;

import com.bestgo.config.dao.AppPromotionRuleMapper;
import com.bestgo.config.dao.AppResourceDataMapper;
import com.bestgo.config.entity.AppPromotionRule;
import com.bestgo.config.entity.AppPromotionRuleExample;
import com.bestgo.config.entity.AppResourceData;
import com.bestgo.config.entity.AppResourceDataExample;
import com.bestgo.config.service.AppPromotionConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Desc: 广告互推 推广配置服务实现
 * Auth: maliang
 * Date: 2018/6/20 12:21
 */
@Service("appPromotionConfigService")
@Transactional
public class AppPromotionConfigServiceImpl implements AppPromotionConfigService {

    @Autowired
    private AppPromotionRuleMapper appPromotionRuleMapper;
    @Autowired
    private AppResourceDataMapper appResourceDataMapper;

    @Override
    public List queryRules(String country, String appPkg) {
        AppPromotionRuleExample example = new AppPromotionRuleExample();
        AppPromotionRuleExample.Criteria criteria = example.createCriteria();
        criteria.andValidstatusEqualTo("1");//状态是有效的

        if(StringUtils.isNotBlank(appPkg)){
            criteria.andAppPkgEqualTo(appPkg);
        }
        if(StringUtils.isNotBlank(country)){
            criteria.andCountryEqualTo(country);
        }
        example.setOrderByClause(" priority ASC");
        List<AppPromotionRule> result = appPromotionRuleMapper.selectByExample(example);

        List rtnList = new ArrayList();
        Map itemRule = null;
        Map action = new HashMap();
        for(AppPromotionRule rule : result){
            itemRule = new HashMap();
            itemRule.put("priority",rule.getPriority());
            itemRule.put("condition",rule.getConditions());

            action.put("type",rule.getActionType());
            action.put("link_url",rule.getLinkUrl());
            action.put("package_name",rule.getPackageName());
            action.put("title",rule.getTitle());
            action.put("message",rule.getMessage());
            action.put("icon_url",rule.getIconUrl());
            action.put("big_image_url",rule.getBigImageUrl());
            action.put("native_image_url",rule.getNativeImageUrl());

            itemRule.put("action",action);
            rtnList.add(itemRule);
        }

        return rtnList;
    }

    @Override
    public List<AppResourceData> queryAppResources(String country, String appPkg) {
        AppResourceDataExample example = new AppResourceDataExample();
        AppResourceDataExample.Criteria criteria = example.createCriteria();
        criteria.andValidstatusEqualTo("1");//状态是有效的
        if(StringUtils.isNotBlank(country)){
            criteria.andCountryEqualTo(country);
        }
        if(StringUtils.isNotBlank(appPkg)){
            criteria.andAppPkgEqualTo(appPkg);
        }
        example.setOrderByClause(" app_type ASC");//根据 app类型升序排列
        List<AppResourceData> result = appResourceDataMapper.selectByExample(example);//查询出所有apptype类型的数据
        Map<String,List<String>> dataMap = new HashMap<String,List<String>>();//按照apptype存储数据
        List<String> appList = null;
        String appType = null;
        for(AppResourceData data : result){
            appType = data.getAppType();
            if(!dataMap.containsKey(appType)){
                appList = new ArrayList<String>();
                dataMap.put(appType,appList);
            }
            appList = dataMap.get(appType);
            appList.add(data.getAppPkg());
        }

        List rtnList = new ArrayList();
        Map obj = null;
        Iterator<String> ite = dataMap.keySet().iterator();
        while (ite.hasNext()){
            appType = ite.next();
            obj = new HashMap();
            obj.put("appType",appType);
            obj.put("appList", dataMap.get(appType));
            rtnList.add(obj);
        }

        return rtnList;
    }

    public AppPromotionRuleMapper getAppPromotionRuleMapper() {
        return appPromotionRuleMapper;
    }

    @Override
    @Transactional
    public void addRule(AppPromotionRule rule) {

    }

    @Override
    @Transactional
    public void addAppResource(AppResourceData resourceData) {

    }
}
