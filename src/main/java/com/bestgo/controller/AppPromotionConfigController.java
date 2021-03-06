package com.bestgo.controller;

import com.bestgo.common.constants.ConfigConstant;
import com.bestgo.common.dto.PageInfo;
import com.bestgo.common.dto.ResponseDto;
import com.bestgo.common.enums.BaseErrorEnum;
import com.bestgo.config.dto.AppPromotionRuleDto;
import com.bestgo.config.dto.AppResourceDataDto;
import com.bestgo.config.entity.AppPromotionRule;
import com.bestgo.config.service.AppPromotionConfigService;
import com.bestgo.user.dto.UserDto;
import org.apache.commons.lang.StringUtils;
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
    public List queryRule(@RequestParam(value = "appPkg",required=false) String appPkg, @RequestParam(value = "country",required=false) String country){

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
    public List queryResource(@RequestParam(value = "appPkg",required=false) String appPkg, @RequestParam(value = "country",required=false) String country){
        List result = appPromotionConfigService.queryAppResources(country,appPkg);
        return result;
    }

    /**
     * 页面查询展示 资源列表
     * @return
     */
    @RequestMapping(value = "/listResource", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto listResource(@RequestBody AppResourceDataDto appResourceDataDto){
        ResponseDto responseDto = ResponseDto.instance(null);

        try{
            PageInfo page = appPromotionConfigService.listAppResources(appResourceDataDto);
            responseDto.setResultObj(page);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    /**
     * 页面查询展示 规则列表
     * @return
     */
    @RequestMapping(value = "/listRule", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto listRule(@RequestBody AppPromotionRuleDto appPromotionRuleDto){
        ResponseDto responseDto = ResponseDto.instance(null);

        try{
            PageInfo page = appPromotionConfigService.listAppRules(appPromotionRuleDto);
            responseDto.setResultObj(page);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    /**
     * 资源详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detailResource", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto detailResource(@RequestParam(value = "id") int id){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            AppResourceDataDto resource = appPromotionConfigService.detailAppResource(id);
            responseDto.setResultObj(resource);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return responseDto;
    }

    /**
     * 规则详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detailRule", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto detailRule(@RequestParam(value = "id") int id){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            AppPromotionRuleDto rule = appPromotionConfigService.detailAppRule(id);
            responseDto.setResultObj(rule);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return responseDto;
    }

    /**
     * 重新执行初始化配置：将数据库批量配置，全部加载到内存
     * @return
     */
    @RequestMapping(value = "/reloadResourceANDRule", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String reloadResourceANDRule(){
        String result = "1";
        try{
            appPromotionConfigService.reloadResourceANDRule();
        }catch (Exception e){
            e.printStackTrace();
            result = "0";
        }
        return result;
    }

    /**
     * 增量刷新资源
     * @return
     */
    @RequestMapping(value = "/incrResource", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseDto incrResource(){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            appPromotionConfigService.incrResource();
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return responseDto;
    }

    /**
     * 增量刷新规则
     * @return
     */
    @RequestMapping(value = "/incrRule", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseDto incrRule(){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            appPromotionConfigService.incrRule();
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return responseDto;
    }

    @RequestMapping(value = "/addAppRule", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto addAppRule(@RequestBody AppPromotionRuleDto appPromotionRuleDto){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            appPromotionConfigService.addAppRule(appPromotionRuleDto);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    @RequestMapping(value = "/updateAppRule", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto updateAppRule(@RequestBody AppPromotionRuleDto appPromotionRuleDto){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            int ret = appPromotionConfigService.updateAppRule(appPromotionRuleDto);
            if (ret != 0) {
                responseDto.setResultMsg("更新成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    @RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto deleteRule(@RequestParam(value = "id") int id){
        ResponseDto responseDto = ResponseDto.instance(null);

        try{
            appPromotionConfigService.deleteRule(id);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    @RequestMapping(value = "/addAppResource", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto addAppResource(@RequestBody AppResourceDataDto appResourceDataDto){
        ResponseDto responseDto = ResponseDto.instance(null);

        try{
            appPromotionConfigService.addAppResource(appResourceDataDto);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

    @RequestMapping(value = "/updateAppResource", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto updateAppResource(@RequestBody AppResourceDataDto appResourceDataDto){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            Integer ret = appPromotionConfigService.updateAppResource(appResourceDataDto);
            if (ret != null) {
                responseDto.setResultMsg("更新成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }


    @RequestMapping(value = "/deleteAppResource", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto deleteResource(@RequestParam(value = "id") int id){
        ResponseDto responseDto = ResponseDto.instance(null);
        try{
            appPromotionConfigService.deleteResource(id);
        }catch (Exception e){
            e.printStackTrace();
            responseDto.setResultCode(BaseErrorEnum.ERROR.getCode());
            responseDto.setResultMsg(BaseErrorEnum.ERROR.getName());
        }
        return  responseDto;
    }

}
