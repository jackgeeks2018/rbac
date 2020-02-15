package com.wpp.controller;

import com.wpp.common.ApplicationContextHelper;
import com.wpp.common.JsonData;
import com.wpp.dao.SysAclModuleMapper;
import com.wpp.exception.ParamException;
import com.wpp.model.SysAclModule;
import com.wpp.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new ParamException("test exception");
        // return JsonData.success("hello, permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate() throws ParamException {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        //BeanValidator.check(vo);
        return JsonData.success("test validate");
    }

}
