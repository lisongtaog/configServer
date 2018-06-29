package com.bestgo.config.dao;

import com.bestgo.config.entity.AppResourceData;
import com.bestgo.config.entity.AppResourceDataExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface AppResourceDataMapper {
    int countByExample(AppResourceDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppResourceData record);

    int insertSelective(AppResourceData record);

    List<AppResourceData> selectByExample(AppResourceDataExample example);

    AppResourceData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppResourceData record);

    int updateByPrimaryKey(AppResourceData record);

    int updateInitStateByCountryPkg(@Param("country") String country, @Param("appPkg") String appPkg);

    List<String> selectDistinctCountry(@Param("init") String init);
}