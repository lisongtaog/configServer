package com.bestgo.config.dao;

import com.bestgo.common.entity.AppCountryCodeDict;
import com.bestgo.common.entity.AppCountryCodeDictExample;
import java.util.List;

public interface AppCountryCodeDictMapper {
    int countByExample(AppCountryCodeDictExample example);

    int deleteByPrimaryKey(String countryCode);

    int insert(AppCountryCodeDict record);

    int insertSelective(AppCountryCodeDict record);

    List<AppCountryCodeDict> selectByExample(AppCountryCodeDictExample example);

    AppCountryCodeDict selectByPrimaryKey(String countryCode);

    int updateByPrimaryKeySelective(AppCountryCodeDict record);

    int updateByPrimaryKey(AppCountryCodeDict record);
}