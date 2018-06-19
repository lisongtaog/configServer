package com.bestgo.user.dao;

import java.util.List;
import java.util.Map;

import com.bestgo.user.dto.UserQueryConditionDto;
import com.bestgo.user.entity.UtiIUser;
import com.bestgo.user.entity.UtiIUserExample;
import com.bestgo.user.entity.UtiIUserKey;
/**
 * @author maliang
 * 用户表-UtiIUser  数据操作接口类
 */
public interface UtiIUserMapper {
	//按照主键删除
    int deleteByPrimaryKey(UtiIUserKey key);
	//插入对象
    int insert(UtiIUser record);
	//插入对象
    int insertSelective(UtiIUser record);
	//系统封装查询
    List<UtiIUser> selectByExample(UtiIUserExample example);
    //系统封装查询
	List<UtiIUser> selectByCondtion(UtiIUserExample example);
	//按主键查询
    UtiIUser selectByPrimaryKey(UtiIUserKey key);
	//主键更新
    int updateByPrimaryKeySelective(UtiIUser record);
	//主键更新
    int updateByPrimaryKey(UtiIUser record);
    // 多条件查询
 	List<UserQueryConditionDto> selectByCondition(UserQueryConditionDto userConditionDto);
 	//多条件查询联系人
 	List<UserQueryConditionDto> selectUserByCondition(UserQueryConditionDto userConditionDto);
 	
}