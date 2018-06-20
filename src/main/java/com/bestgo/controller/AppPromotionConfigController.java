package com.bestgo.controller;

import com.bestgo.common.dto.ResponseDto;
import com.bestgo.config.service.AppPromotionConfigService;
import com.bestgo.user.dto.UserDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Desc: 广告互推 推广服务接口
 * Auth: maliang
 * Date: 2018/6/20 12:22
 */
@Controller
@RequestMapping("/appPromotionConfig")
public class AppPromotionConfigController {
    private static Log LOGGER = LogFactory.getLog(AppPromotionConfigController.class);

    @Autowired
    AppPromotionConfigService appPromotionConfigService;


    @RequestMapping(value = "/queryRule", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List queryRule(@RequestParam("appPkg") String appPkg, @RequestParam("country") String country){

        List result = appPromotionConfigService.queryRules(country,appPkg);

        //ResponseDto result  = appPromotionConfigService.saveUser(userDto);
        //return ResponseDto.instance(result);
        return result;
    }

    /**
     * 查询app资源
     * @param appPkg    应用包名
     * @param country   国家
     * @return
     */
    @RequestMapping(value = "/queryResource", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    //public List queryResource(@RequestParam String id, @RequestParam String country){//常用来处理简单数据类型的绑定
    //public List queryResource(HttpServletRequest request, HttpServletResponse response){//通过request获取参数
    //public List queryResource(@RequestBody AppResourceData appResource){//此方案是 前端传json格式字符串
    //public List queryResource(AppResourceData appResource){//form 表单提交
    public List queryResource(@RequestParam("appPkg") String appPkg, @RequestParam("country") String country){
        System.out.println(appPkg);
        System.out.println(country);
        List result = appPromotionConfigService.queryAppResources(country,appPkg);
        return result;
    }

}
