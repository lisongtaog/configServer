package com.bestgo.controller;

import com.bestgo.common.service.AppCountryCodeDictService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/DropdownMenu")
public class SelectDropdownController {
    private static Log LOGGER = LogFactory.getLog(AppPromotionConfigController.class);

    @Autowired
    AppCountryCodeDictService appCountryCodeDictService;


    @RequestMapping(value = "/queryCountry", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List listCountry(){
        List result = appCountryCodeDictService.listCountryCodeDict();
        return result;
    }
}
