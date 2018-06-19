package com.bestgo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestgo.common.dto.PageInfo;
import com.bestgo.common.dto.ResponseDto;
import com.bestgo.common.service.TransformService;
import com.bestgo.user.dto.UserDto;
import com.bestgo.user.dto.UserQueryConditionDto;
import com.bestgo.user.service.UserService;


/**
 * @description （用户关联服务）
 * @author chengzhuo
 * @date 2016年9月25日下午5:40:49
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController
{

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;


	@Autowired
	TransformService transformService;

    /**
     * @description （ 保存用户信息 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:15:48
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto save(@RequestBody UserDto userDto){
        ResponseDto result  = userService.saveUser(userDto);
        return ResponseDto.instance(result);
    }

    /**
     * @description （ 修改用户信息 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:16:12
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto update(@RequestBody UserDto userDto){
        ResponseDto result = userService.updateUser(userDto);
        return ResponseDto.instance(result);
    }

    /**
     * @description （ 密码修改 ）
     * @param user_Code
     * @param newPassWord
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:16:46
     */
    @RequestMapping(value = "/updatePasswd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto updatePwd(@RequestBody UserDto userDto)
        
    {
        ResponseDto result =  userService.updatePasswd(userDto);
        return ResponseDto.instance(result);
    }

	/**
	 * 删除用户信息
	 * 
	 * @param userDto
	 * @return ResponseDto.instance(count)
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto delete(@RequestBody UserDto userDto) throws Exception {
		int count = userService.deleteByUserCode(userDto.getUserCode());
		return ResponseDto.instance(count);
	}

	/**
	 * 通过用户号查询用户信息
	 * 
	 * @param userDto
	 * @return ResponseDto.instance(count)
	 */
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto detail(@RequestBody UserDto userDto) throws Exception {
		UserDto _userDto = userService.selectByUserCode(userDto.getUserCode());
		transformService.trasnObject(_userDto);
		return ResponseDto.instance(_userDto);
	}

	/**
	 * 查询联系人列表
	 * 
	 * @param conditionDto
	 * @return ResponseDto.instance(pageInfo)
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto userList(@RequestBody UserQueryConditionDto conditionDto) throws Exception {
		logger.info("开始查询列表----");
		PageInfo<UserDto> pageInfo = userService.queryUser(conditionDto);
		logger.info("查询列表结束----");
		return ResponseDto.instance(pageInfo);
	}
}