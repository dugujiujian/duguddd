package com.dugu.ddd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cihun
 * @date 2021-10-09 6:55 下午
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/auth/verify-code")
    public String verifyCode() {
        return "login";
    }

}
