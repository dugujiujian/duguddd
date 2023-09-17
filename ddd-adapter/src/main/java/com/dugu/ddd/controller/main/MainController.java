package com.dugu.ddd.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cihun
 * @date 2021-10-09 6:55 下午
 */
@Controller
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "hello, spring boot!";
    }



}
