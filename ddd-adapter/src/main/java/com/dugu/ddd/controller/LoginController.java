package com.dugu.ddd.controller;

import com.dugu.base.open.result.Result;
import com.dugu.ddd.application.user.UserManager;
import com.dugu.ddd.domain.login.req.UserLoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author cihun
 * @date 2024/5/10 12:39
 */
@RestController
public class LoginController {
    @Autowired
    private UserManager userManager;

    @PostMapping("/logon")
    public Result<String> logon(@RequestBody UserLoginReq userLoginReq) {
        userManager.login(userLoginReq.getUsername(), userLoginReq.getPassword());
        return Result.success();
    }


}