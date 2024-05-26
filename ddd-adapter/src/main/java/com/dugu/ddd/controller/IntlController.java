package com.dugu.ddd.controller;

import com.dugu.base.open.result.Result;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author cihun
 * @date 2024/5/20 15:35
 */
@RestController
@RequestMapping("/v1/system/internationalization")
public class IntlController {


    @ResponseBody
    @RequestMapping("/allLocales")
    public Result<Map<String, Map<String, String>>> verifyCode() {
        Map<String, Map<String, String>> result = Maps.newHashMap();
        Map<String, String> zhCnItemMap = Maps.newHashMap();
        zhCnItemMap.put("pages.user.login.subtitle", "独孤斋办公系统");
        zhCnItemMap.put("pages.user.login.type.account", "账号登录");
        zhCnItemMap.put("pages.user.login.type.mobile", "手机登录");
        zhCnItemMap.put("type.account.user_name.placeholder", "请输入账号");
        zhCnItemMap.put("type.account.user_name.required", "账号必须填写");
        zhCnItemMap.put("type.account.password.placeholder", "请输入密码");
        zhCnItemMap.put("type.account.password.required", "密码必须填写");
        zhCnItemMap.put("type.mobile.captcha", "请输入验证码");
        zhCnItemMap.put("global.form.placeholder", "请输入");
        zhCnItemMap.put("pages.user.login.type.mobile.captcha", "验证码");

        result.put("zh-CN", zhCnItemMap);
        return Result.success(result);
    }
}
