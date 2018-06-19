package com.bestgo.user.service;

import com.bestgo.common.dto.ResponseDto;
import com.bestgo.user.dto.UserDto;
import com.bestgo.user.dto.UtiIUserDto;



/**
 * @description 用户登录服务
 * @author maliang
 *
 */
public interface UserLoginService {
	
	/**
	* @description （用户登录验证）
	* @param userDto
	* @return
	* @author maliang
	* @date 2016年9月23日下午4:44:53
	*/

	public UtiIUserDto checkUserLogin(UtiIUserDto userDto) ;
	
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return

	* @
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/

	public ResponseDto forgetPwd(UserDto userDto) ;
	
}

