package com.bestgo.config.service.impl;

import com.bestgo.common.constants.ConfigConstant;
import com.bestgo.config.dao.AppPromotionRuleMapper;
import com.bestgo.config.dao.AppResourceDataMapper;
import com.bestgo.config.entity.AppPromotionRule;
import com.bestgo.config.entity.AppPromotionRuleExample;
import com.bestgo.config.entity.AppResourceData;
import com.bestgo.config.entity.AppResourceDataExample;
import com.bestgo.config.service.AppPromotionConfigService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc: 广告互推 推广配置服务实现
 * Auth: maliang
 * Date: 2018/6/20 12:21
 */
@Service("appPromotionConfigService")
public class AppPromotionConfigServiceImpl implements AppPromotionConfigService {
    private static Log LOGGER = LogFactory.getLog(AppPromotionConfigServiceImpl.class);
    /**内存缓存-资源*/
    private static final Map<String,List> CACHE_RESOURCE = new ConcurrentHashMap<String,List>();
    /**内存缓存-规则*/
    private static final Map<String,List> CACH_RULE = new ConcurrentHashMap<String,List>();

    @Autowired
    private AppPromotionRuleMapper appPromotionRuleMapper;
    @Autowired
    private AppResourceDataMapper appResourceDataMapper;


    @Override
    public List queryRules(String country, String appPkg){
        Long begin = System.currentTimeMillis();
        LOGGER.info("查询规则缓存开始：country:"+country+"appPkg:"+appPkg+"###");
        List rtnList = null;
        if(StringUtils.isBlank(country) && StringUtils.isBlank(appPkg)){//country、appPkg未传 认为完全不匹配
            return CACH_RULE.get(getCacheKey(ConfigConstant.DEFAULT,ConfigConstant.DEFAULT));
        }
        if(StringUtils.isNotBlank(country) && StringUtils.isNotBlank(appPkg)){
            rtnList = CACH_RULE.get(getCacheKey(country,appPkg));
        }else if (StringUtils.isNotBlank(country)){
            rtnList = CACH_RULE.get(getCacheKey(country,ConfigConstant.DEFAULT));
        }else {
            rtnList = CACH_RULE.get(getCacheKey(ConfigConstant.DEFAULT,appPkg));
        }

        if (rtnList == null){//规则无法匹配时，使用系统全局默认规则
            rtnList = CACH_RULE.get(getCacheKey(ConfigConstant.DEFAULT,ConfigConstant.DEFAULT));
        }
        Long end = System.currentTimeMillis();
        LOGGER.info("查询规则缓存结束,耗时"+ (end - begin) +"毫秒");
        return rtnList;
    }

    private List fecthRules(String country, String appPkg) {
        //boolean isSystemDefault = false;//是否使用全局默认配置
        int fixLevel = isRuleExists(country,appPkg);//检查规则查询条件匹配程度

        AppPromotionRuleExample example = new AppPromotionRuleExample();
        AppPromotionRuleExample.Criteria criteria = example.createCriteria();
        criteria.andValidstatusEqualTo("1");//状态是有效的

        //规则是以应用包为基准查找的
        if(fixLevel == 0){//如果包名未传，或者不匹配，则全部取默认配置
            country = ConfigConstant.DEFAULT;
            appPkg = ConfigConstant.DEFAULT;
            //isSystemDefault = true;//使用全局默认配置
            criteria.andCountryEqualTo(country);
            criteria.andAppPkgEqualTo(appPkg);
        }else if(fixLevel == 1){//完全匹配
            criteria.andCountryEqualTo(country);
            criteria.andAppPkgEqualTo(appPkg);
        }else if(fixLevel == 2){//仅country匹配
            criteria.andCountryEqualTo(country);
        }else if(fixLevel == 3){//仅appPkg匹配
            criteria.andAppPkgEqualTo(appPkg);
        }
        example.setOrderByClause(" priority ASC");
        List<AppPromotionRule> result = appPromotionRuleMapper.selectByExample(example);

        if(result == null || result.size() == 0){//此逻辑认为appPkg传递正确/国家错误，如果通过appPkg查询无数据，则查询这appPkg个默认的（国家为DEFAULT）
            example.clear();
            criteria = example.createCriteria();
            criteria.andValidstatusEqualTo("1");//状态是有效的
            criteria.andAppPkgEqualTo(ConfigConstant.DEFAULT);
            criteria.andCountryEqualTo(ConfigConstant.DEFAULT);
            example.setOrderByClause(" priority ASC");
            result = appPromotionRuleMapper.selectByExample(example);
        }

        List rtnList = packageRules(result);//封装返回的rules规则

        return rtnList;
    }

    /**
     * 查找rules匹配程度
     * @param country
     * @param appPkg
     * @return
     */
    private int isRuleExists(String country, String appPkg){
        int result = 0;//完全不匹配
        int count = 0;
        if(StringUtils.isBlank(country) && StringUtils.isBlank(appPkg)){//country、appPkg未传 认为完全不匹配
            return result;
        }
        //计数
        AppPromotionRuleExample countExample = new AppPromotionRuleExample();
        AppPromotionRuleExample.Criteria countCriteria = countExample.createCriteria();

        if (StringUtils.isNotBlank(country) && StringUtils.isNotBlank(appPkg)){//完全匹配维度查找
            countCriteria.andCountryEqualTo(country);
            countCriteria.andAppPkgEqualTo(appPkg);
            count = appPromotionRuleMapper.countByExample(countExample);
            result = count > 0 ? 1 : 0;
        }

        if(count == 0 && StringUtils.isNotBlank(country)){//国家维度查找
            countExample.clear();
            countCriteria = countExample.createCriteria();
            countCriteria.andCountryEqualTo(country);
            count = appPromotionRuleMapper.countByExample(countExample);
            result = count > 0 ? 2 : 0;
        }

        if(count == 0 && StringUtils.isNotBlank(appPkg)){//appPkg维度查找
            countExample.clear();
            countCriteria = countExample.createCriteria();
            countCriteria.andAppPkgEqualTo(appPkg);
            count = appPromotionRuleMapper.countByExample(countExample);
            result = count > 0 ? 3 : 0;
        }

        //0：均不匹配 1：完全匹配 2：国家匹配、appPkg不匹配 3：appPkg匹配、国家不匹配
        return result;
    }

    /**
     * 封装返回的rules规则
     * @param result
     * @return
     */
    private List packageRules(List<AppPromotionRule> result){
        List rtnList = new ArrayList();
        Map itemRule = null;
        Map action = null;
        for(AppPromotionRule rule : result){
            itemRule = new HashMap();
            itemRule.put("priority",rule.getPriority());
            itemRule.put("condition",rule.getConditions());

            action = new HashMap();
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

        return  rtnList;
    }

    @Override
    public List<AppResourceData> queryAppResources(String country, String appPkg){
        Long begin = System.currentTimeMillis();
        LOGGER.info("&&&查询资源缓存开始：country:"+country+"appPkg:"+appPkg+"&&&");
        List rtnList = null;
        if(StringUtils.isBlank(country) || !CACHE_RESOURCE.containsKey(getCacheKey(country,null))){
            country = ConfigConstant.DEFAULT;//默认国家配置
            rtnList = CACHE_RESOURCE.get(getCacheKey(country,null));
        }else {
            rtnList = CACHE_RESOURCE.get(getCacheKey(country,null));
        }
        Long end = System.currentTimeMillis();
        LOGGER.info("&&&查询资源缓存结束,耗时"+ (end - begin) +"毫秒&&&");
        return  rtnList;
    }

    private List<AppResourceData> fetchAppResources(String country, String appPkg) {
        if(StringUtils.isBlank(country)){
            country = ConfigConstant.DEFAULT;//默认国家配置
        }
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

        if(result == null || result.size() == 0){//如果通过country查询无数据，则查询默认的（国家为DEFAULT）
            example.clear();
            criteria = example.createCriteria();
            criteria.andValidstatusEqualTo("1");//状态是有效的
            criteria.andCountryEqualTo(ConfigConstant.DEFAULT);
            example.setOrderByClause(" app_type ASC");
            result = appResourceDataMapper.selectByExample(example);
        }

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


    /**
     *  应用启动后，执行初始化：将数据库数据加载进入内存
     *  批量将配置数据，全部加载到内存
     */
    @PostConstruct
    private void initResourceANDRule(){
        List<String> resourceCountry = appResourceDataMapper.selectDistinctCountry(null);
        List resourceList = null;
        String key = null;
        for (String country : resourceCountry){
            key = getCacheKey(country,null);
            resourceList = fetchAppResources(country,null);
            CACHE_RESOURCE.put(key , resourceList);
        }

        List<AppPromotionRule> ruleCountryPkg= appPromotionRuleMapper.selectDistinctCountryPkg(null);
        List ruleList = null;
        for(AppPromotionRule rule : ruleCountryPkg){
            key = getCacheKey(rule.getCountry(),rule.getAppPkg());
            ruleList = fecthRules(rule.getCountry(),rule.getAppPkg());
            CACH_RULE.put(key , ruleList);
        }
    }

    /**
     *  重新执行初始化配置：将数据库批量配置，全部加载到内存
     */
    @Override
    public synchronized void reloadResourceANDRule(){
        CACHE_RESOURCE.clear();
        CACH_RULE.clear();
        initResourceANDRule();
    }

    /**
     * 增量刷新、配置 appPkg资源信息
     */
    @Transactional
    public void incrResource(){
        List<String> resourceCountry = appResourceDataMapper.selectDistinctCountry(ConfigConstant.VALIDSTATUS_NO);//取未初始化 加载到缓存的
        List resourceList = null;
        String key = null;
        for (String country : resourceCountry){
            key = getCacheKey(country,null);
            if (CACHE_RESOURCE.containsKey(key)){
                CACHE_RESOURCE.remove(key);
            }
            resourceList = fetchAppResources(country,null);
            CACHE_RESOURCE.put(key , resourceList);
            appResourceDataMapper.updateInitStateByCountryPkg(country,null);
        }
    }
    /**
     *  增量刷新、配置 规则信息
     */
    @Transactional
    public void incrRule(){
        List<AppPromotionRule> ruleCountryPkg= appPromotionRuleMapper.selectDistinctCountryPkg(ConfigConstant.VALIDSTATUS_NO);//取未初始化 加载到缓存的
        List ruleList = null;
        String key = null;
        for(AppPromotionRule rule : ruleCountryPkg){
            key = getCacheKey(rule.getCountry(),rule.getAppPkg());
            if (CACH_RULE.containsKey(key)){
                CACH_RULE.remove(key);
            }
            ruleList = fecthRules(rule.getCountry(),rule.getAppPkg());
            CACH_RULE.put(key , ruleList);
            appPromotionRuleMapper.updateInitStateByCountryPkg(rule.getCountry(),rule.getAppPkg());
        }
    }

    /**
     * 获取缓存key值
     * @param country
     * @param appPkg
     * @return
     */
    private String getCacheKey(String country,String appPkg){
        StringBuffer key = new StringBuffer();
        if(StringUtils.isBlank(country) && StringUtils.isBlank(appPkg)){
            key.append(ConfigConstant.DEFAULT).append("_").append(ConfigConstant.DEFAULT);
        }else{
            key.append(country).append("_").append(appPkg);
        }
        return key.toString();
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
