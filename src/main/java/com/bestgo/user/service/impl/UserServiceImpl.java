package com.bestgo.user.service.impl;

import java.util.Date;
import java.util.List;

import com.bestgo.common.enums.ImsErrorEnum;
import com.bestgo.user.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bestgo.common.dto.PageInfo;
import com.bestgo.common.dto.ResponseDto;
import com.bestgo.common.service.AbstractPageQuery;
import com.bestgo.common.service.BeanConverter;
import com.bestgo.common.util.PwdUtil;
import com.bestgo.user.dao.UtiIAccountMapper;
import com.bestgo.user.dao.UtiIUserMapper;
import com.bestgo.user.dto.AccountDto;
import com.bestgo.user.dto.UserDto;
import com.bestgo.user.dto.UserQueryConditionDto;
import com.bestgo.user.dto.UtiIUserDto;
import com.bestgo.user.service.UserService;

@Service("userService")
@PropertySource(value = {"classpath:comm/config/application.properties"}) 
@Transactional
public class UserServiceImpl implements UserService {
	
	/** 系统默认加密秘钥key */
	public static final String ENCRYPTKEY = "www.zenithib.com";

    /** log日志 */
    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UtiIAccountMapper utilAccoutnMapper;


    @Autowired
    private UtiIUserMapper utiIUserMapper;

    @Autowired
    private BeanConverter beanConverter;
    
    /**
     * @description 单个用户增添服务
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:20:46
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto saveUser(UserDto userDto)  {
    	String strUserCode = userDto.getUserCode();
        ResponseDto result = new ResponseDto();
        
        //用户重复性校验
        UtiIUserKey userKey = new UtiIUserKey();
        userKey.setUserCode(strUserCode);
        UtiIUser _utiIUser = utiIUserMapper.selectByPrimaryKey(userKey);

        if (_utiIUser != null) {
            result.setResultMsg(_utiIUser.getUserCode() + "用户账号已存在，请勿重复使用");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }

        // 1.3生成当前时间
        Date date = new Date();
        UtiIUser utiIUser = new UtiIUser();

        beanConverter.convert(userDto, utiIUser);
        utiIUser.setUserType("02");
        utiIUser.setCreateDate(date);
//        utiIUser.setCreatorCode();
        utiIUser.setValidStatus("1");
        utiIUser.setFlag("1");


        // 7、保存用户信息
        utiIUserMapper.insert(utiIUser);

        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

    /**
     * @description 修改用户个人信息
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:00
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto updateUser(UserDto userDto)  {

        ResponseDto result = new ResponseDto();
        UtiIUser utiIUser = new UtiIUser();
        String userCode = userDto.getUserCode();
        Date date = new Date();

        // 1.类型转换
        beanConverter.convert(userDto, utiIUser);
        //1.1设置必须值
        utiIUser.setUpdateDate(date);
//        utiIUser.setUpdaterCode();
        utiIUser.setFlag("1");

        // 3.保存用户信息
        utiIUserMapper.updateByPrimaryKeySelective(utiIUser);

        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

	@Override
	public int deleteByUserCode(String userCode) {
		int count = 0;
		if (null != userCode && !"".equals(userCode)) {
			count = utiIUserMapper.deleteByPrimaryKey(new UtiIUserKey(userCode));
			utilAccoutnMapper.deleteByUserCode(userCode);
		}
		return count;
	}

	/**
     * @description 查看详情
     * @param 
     * @return UserDto
     */
	@Override
	public UserDto selectByUserCode(String userCode) {
		if (null == userCode || "".equals(userCode)) {
			return null;
		}

		UtiIUser utiIUser = utiIUserMapper.selectByPrimaryKey(new UtiIUserKey(userCode));

		UserDto userDto = new UserDto();
		beanConverter.convert(utiIUser, userDto);

		return userDto;
	}


	/**
     * @description 分页查询
     * @author ww
     * @param userDto
     * @return userDto
     */
	public PageInfo<UserDto> queryUser(UserQueryConditionDto queryconditionDto){
		PageInfo<UserDto> pageDto = null;
		AbstractPageQuery<UserQueryConditionDto,UserDto> query = new AbstractPageQuery<UserQueryConditionDto,UserDto>(){

			@Override
			protected List<UserQueryConditionDto> doQueryPage(UserQueryConditionDto conditionDto) {
				return utiIUserMapper.selectUserByCondition(conditionDto);
			}
			@Override
			protected UserDto beanConvert(Object src) {
				return beanConverter.convert(src,UserDto.class);
			}
		};
		pageDto = query.queryPage(queryconditionDto);
		return pageDto;
	}

    /**
     * @description 修改密码服务
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月20日上午9:21:33
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDto updatePasswd(UserDto userDto)  {

        ResponseDto result = new ResponseDto();
        Date date = new Date();
        String password = new String();
        String userCode = null;
        // 获取密码&加密
        password = userDto.getNewPassword();
        userCode = userDto.getUserCode();
        String md5Pwd = PwdUtil.md5(password);

        //如果密码不存在
        if(password==null){
            result.setResultMsg("请输入密码");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }
        // 通过userCode查询该userCode所有的账户
        UtiIAccountExample example = new UtiIAccountExample();
        example.createCriteria().andUserCodeEqualTo(userCode);

        UtiIAccount account = null;
        try {
            account = utilAccoutnMapper.selectByPrimaryKey(new UtiIAccountKey(userCode));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        if (account == null) {
            result.setResultMsg("该用户不存在");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());
            return result;
        }

        // 给所有账户设置密码
        int count = 0;
        account.setPassWord(md5Pwd);
        account.setPasswdSetDate(date);
        account.setPasswdExpireDate(new Date());
        account.setUpdateDate(new Date());
        //account.setUpdaterCode();
        count = utilAccoutnMapper.updateByPrimaryKeySelective(account);
        if (count == 0) {
            result.setResultMsg("修改未成功");
            result.setResultCode(ImsErrorEnum.IMS_ERROR.getCode());

            return result;
        }
        result.setResultCode(ImsErrorEnum.IMS_SUCCESS.getCode());
        result.setResultMsg(ImsErrorEnum.IMS_SUCCESS.getName());
        return result;
    }

}
