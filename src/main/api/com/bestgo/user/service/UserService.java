package com.bestgo.user.service;

import java.util.List;
import java.util.Map;

import com.bestgo.common.dto.PageInfo;
import com.bestgo.common.dto.ResponseDto;
import com.bestgo.user.dto.UserDto;
import com.bestgo.user.dto.UserQueryConditionDto;

public interface UserService {

	/**
	 * @description 单个用户增添服务
	 * @param userDto
	 * @return ResponseDto
	 * @author chengzhuo
	 * @date 2016年9月20日上午9:20:46
	 */
	public ResponseDto saveUser(UserDto userDto) ;

	/**
	 * @description 修改用户
	 * @param userDto
	 * @return ResponseDto
	 * @author dongyingchun
	 * @date 2016年9月20日上午9:21:00
	 */
	public ResponseDto updateUser(UserDto userDto) ;

	/**
	 * 通过主键UserCode删除
	 * 
	 * @param userCode
	 * @return int
	 */
	public int deleteByUserCode(String userCode);

	/**
	 * 根据主键UserCode查询
	 * @param userCode
	 * @return
	 */
	public UserDto selectByUserCode(String userCode);


	/**
     * @description 分页查询再保联系人
     * @author ww
     * @param queryconditionDto 联系人查询信息
     * @return userDto
     */
	public PageInfo<UserDto> queryUser(UserQueryConditionDto queryconditionDto);

	/**
	 * @description 修改密码服务
	 * @param userDto
	 * @return ResponseDto
	 */
	public ResponseDto updatePasswd(UserDto userDto) ;
	
}
