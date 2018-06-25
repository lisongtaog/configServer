package com.bestgo.config.dao;

import com.bestgo.config.entity.AppPromotionRule;
import com.bestgo.config.entity.AppPromotionRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppPromotionRuleMapper {
    int countByExample(AppPromotionRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppPromotionRule record);

    int insertSelective(AppPromotionRule record);

    List<AppPromotionRule> selectByExample(AppPromotionRuleExample example);

    AppPromotionRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppPromotionRule record);

    int updateByPrimaryKey(AppPromotionRule record);

    int updateInitStateByCountryPkg(@Param("country") String country, @Param("appPkg") String appPkg);

    List<AppPromotionRule> selectDistinctCountryPkg(@Param("init") String init);
}