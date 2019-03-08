package com.bestgo.common.service.impl;
import com.bestgo.common.entity.AppCountryCodeDictExample;
import com.bestgo.common.service.AppCountryCodeDictService;
import com.bestgo.common.service.BeanConverter;
import com.bestgo.config.dao.AppCountryCodeDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
            rtnList = appCountryCodeDictMapper.selectByExample(example);
        }catch (Exception e){
            e.printStackTrace();
        }

        return rtnList;
    }
}
