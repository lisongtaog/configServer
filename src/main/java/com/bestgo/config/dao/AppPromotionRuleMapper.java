package com.bestgo.config.dao;

import com.bestgo.config.entity.AppPromotionRule;
import com.bestgo.config.entity.AppPromotionRuleExample;

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
}