package com.bestgo.user.dao;

import java.util.List;

import com.bestgo.user.entity.UtiIAccount;
import com.bestgo.user.entity.UtiIAccountExample;
import com.bestgo.user.entity.UtiIAccountKey;
/**
 * @author maliang
 * 账户表-UtiIAccount  数据操作/用户账号接口类
 */
public interface UtiIAccountMapper {
	//按照主键删除
    int deleteByPrimaryKey(UtiIAccountKey key);
    int deleteByUserCode(String userCode);
	//插入对象
    int insert(UtiIAccount record);
	//插入对象
    int insertSelective(UtiIAccount record);
	//系统封装查询
    List<UtiIAccount> selectByExample(UtiIAccountExample example);
    //系统封装查询
	List<UtiIAccount> selectByCondtion(UtiIAccountExample example);
	//按主键查询
    UtiIAccount selectByPrimaryKey(UtiIAccountKey key);
	//主键更新
    int updateByPrimaryKeySelective(UtiIAccount record);
	//主键更新
    int updateByPrimaryKey(UtiIAccount record);    
}