package com.dugu.ddd.controller;

import com.dugu.ddd.domain.dto.request.LoginUserReq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cihun
 * @date 2024/5/10 12:39
 */

@Controller
public class LoginController {


    @ResponseBody
    @RequestMapping("/login")
    public String index(@RequestBody LoginUserReq user) {
        if (!user.getUsername().equals("aaa")) {
            return "USER_NOT_EXIST";
        }
        if (user.getPassword().equals("000000")) {
            return "ACCOUNT_OLD";
        }
        if (!user.getPassword().equals("111111")) {
            return "PASSWORD_ERR";
        }
        return "SUCCESS";

    }

    @RequestMapping("/logon")
    public String login() {
        return "login.html";
    }

}