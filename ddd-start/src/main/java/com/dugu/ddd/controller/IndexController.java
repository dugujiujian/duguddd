package com.dugu.ddd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cihun
 * @date 2021-10-09 6:55 下午
 */
@RestController
public class IndexController {

    @RequestMapping(value = {"index", "/"})
    public String index() {
        return "hello, spring boot!";
    }



}
