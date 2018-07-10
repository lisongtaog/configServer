package com.bestgo.common.service.impl;
import com.bestgo.common.entity.AppCountryCodeDictExample;
import com.bestgo.common.service.AppCountryCodeDictService;
import com.bestgo.common.service.BeanConverter;
import com.bestgo.config.dao.AppCountryCodeDictMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.bestgo.common.entity.AppCountryCodeDict;
import org.springframework.stereotype.Service;

@Service
public class AppCountryCodeDictServiceImpl implements AppCountryCodeDictService {

    @Autowired
    private BeanConverter beanConverter;
    /**内存缓存-资源*/
    private static final Map<String,List> CACHE_RESOURCE = new ConcurrentHashMap<String,List>();
    /**内存缓存-规则*/
    private static final Map<String,List> CACH_RULE = new ConcurrentHashMap<String,List>();

    @Autowired
    private AppCountryCodeDictMapper appCountryCodeDictMapper;

    @Override
    public List listCountryCodeDict(){

        AppCountryCodeDictExample example = new AppCountryCodeDictExample();
        List rtnList = new ArrayList();
        try{
            example.setOrderByClause(" country_code ASC");
            List<AppCountryCodeDict> result = appCountryCodeDictMapper.selectByExample(example);

            if(result == null || result.size() == 0){//此逻辑认为appPkg传递正确/国家错误，如果通过appPkg查询无数据，则查询这appPkg个默认的（国家为DEFAULT）
                example.clear();
                example.setOrderByClause(" priority ASC");
                result = appCountryCodeDictMapper.selectByExample(example);
            }

            rtnList = pakageCountrys(result); //封装国家列表
        }catch (Exception e){
            e.printStackTrace();
        }

        return rtnList;
    }

    // 打包返回的查询结果
    public List pakageCountrys(List<AppCountryCodeDict> result){
        List rtnList = new ArrayList();
        Map country = null;

        for(AppCountryCodeDict one : result){
            country = new HashMap();
            country.put("country_name",one.getCountryName());
            country.put("country_code",one.getCountryCode());
            rtnList.add(country);
        }

        return  rtnList;
    }
}
