package com.bestgo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bestgo.common.service.CodeService;
import com.bestgo.common.util.transform.TransfromInter;

/**
 * @description 转码服务实现类
 * @author zkr13
 * @date 2016年10月10日上午10:04:13
 */
public class TransCodeServiceImpl implements TransfromInter
{
    @Autowired
    private CodeService codeService;

    public void setCodeService(CodeService codeService)
    {
        this.codeService = codeService;
    }

    @Override
    public Object transVal(String codeType, Object srcVal)
    {
        if(null!=codeService && null!=srcVal){

            //调用ims服务获取用户名称信息
            if("User".equals(codeType)){

            }else if("Company".endsWith(codeType)){//调用ims服务获取机构名称信息

            }else{//通用配置 服务转码；uti_code表:codeType、codeCode、codeName等等

            }
        }

        return srcVal;
    }

}
