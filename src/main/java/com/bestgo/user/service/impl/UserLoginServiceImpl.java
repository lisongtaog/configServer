package com.bestgo.user.service.impl;

import com.bestgo.common.dto.ResponseDto;
import com.bestgo.common.exception.BusinessException;
import com.bestgo.common.util.PwdUtil;
import com.bestgo.user.dao.UtiIAccountMapper;
import com.bestgo.user.dao.UtiIUserMapper;
import com.bestgo.user.entity.UtiIAccount;
import com.bestgo.user.entity.UtiIAccountExample;
import com.bestgo.user.entity.UtiIUser;
import com.bestgo.user.entity.UtiIUserKey;
import com.bestgo.user.service.UserLoginService;
import com.bestgo.user.service.UserService;
import com.bestgo.common.service.BeanConverter;
import com.bestgo.user.dto.UserDto;
import com.bestgo.user.dto.UtiIUserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userLoginService")
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

	/** log日志 */
	private static Log LOGGER = LogFactory.getLog(UserLoginServiceImpl.class);
	private static final String CURRENT_USER = "currentUser";

	@Autowired
	private UtiIAccountMapper utilAccoutnMapper;

	@Autowired
	private UtiIUserMapper utiIUserMapper;
	
	@Autowired
	private BeanConverter beanConverter;

	@Autowired
	private UserService userService;

	/**
	 * @description 用户登录校验
	 * @author chengzhuo
	 * @return UserReturnDto
	 * @data 2016/9/20 10:55
	 */
	@Override
	public UtiIUserDto checkUserLogin(UtiIUserDto userDto)  {
		
			UtiIUserKey utiIUserKey = new UtiIUserKey();
			UtiIUser utiIUser = new UtiIUser();
			UtiIUserDto resultUserDto = new UtiIUserDto();
			UtiIAccountExample example = new UtiIAccountExample();
			String userCode = userDto.getUserCode();

			/* 通过userCode获取用户表，判断用户表是否存在 */
			utiIUserKey.setUserCode(userCode);
			utiIUser = utiIUserMapper.selectByPrimaryKey(utiIUserKey);
			if(utiIUser ==null){

				throw new BusinessException("用户名或密码错误");
			}
			// 密码加密&获取用户密码
			String password = userDto.getPassWord();
			String md5Pwd = PwdUtil.md5(password);
			example.createCriteria().andUserCodeEqualTo(userDto.getUserCode());
			List<UtiIAccount> list = utilAccoutnMapper.selectByExample(example);
			String userPwd = list.get(0).getPassWord();

			// 判断密码是否相同&返回状态和用户个人信息
			if (!userPwd.equals(md5Pwd)) {

				throw new BusinessException("用户名或密码错误");
			}
			beanConverter.convert(utiIUser, resultUserDto);
			return resultUserDto;
	}
	
	/**
	* @description 忘记密码服务
	* @param userDto
	* @return ResponseDto
	* @throws Exception
	* @author chengzhuo
	* @date 2016年10月22日上午11:29:31
	*/
	@Override

	public ResponseDto forgetPwd(UserDto userDto) {
		ResponseDto responseDto = new ResponseDto();
		ResponseDto resultPasswd = new ResponseDto();

		//4、生成密码
		String newPasswd = generatePwd();
		//5、修改密码服务
		userDto.setNewPassword(newPasswd);
		resultPasswd = userService.updatePasswd(userDto);
		if(resultPasswd==null||resultPasswd.getResultCode()=="9999"){
			responseDto.setResultCode("9999");
			responseDto.setResultMsg("对不起，修改密码失败，请联系管理员");
			return responseDto;
		}
		//6、调用发送邮箱服务(需要邮箱和密码)
		responseDto.setResultCode("0000");
		responseDto.setResultMsg("重新生成的密码已发送至邮箱");
		return responseDto;
	}
	
	/**
	* @description 生成由数字字母符号组成的明文密码
	* @return String
	* @author chengzhuo
	* @date 2016年10月25日上午11:19:45
	*/
	public String generatePwd(){
		StringBuffer password = new StringBuffer();
        for(int i = 0; i <= (int)(Math.random()*9)+7; i++) {
            int ran = (int)(Math.random()*94) + 33;
            char c = (char) ran;
            password.append(c);
        }
        String pwd = password.toString();
		return pwd;
	}
}
