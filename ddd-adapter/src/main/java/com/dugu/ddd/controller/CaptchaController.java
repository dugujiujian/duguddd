package com.dugu.ddd.controller;

import com.dugu.ddd.infra.mw.cache.redis.RedisUtil;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 验证码
 *
 * @author cihun
 * @date 2024/5/18 16:48
 */
@Controller
public class CaptchaController {

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping("/v1/captcha")
    public void C(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        // 几位数运算，默认是两位
        captcha.setLen(3);
        // 获取运算的公式：3+2=?
        captcha.getArithmeticString();
        // 获取运算的结果：5
        String result = captcha.text();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为30分钟
        redisUtil.set(key, result, 300);
        // 输出验证码
        // 将key和base64返回给前端

//        response.setContentType("image/png");
//        response.setHeader("Cache-Control", "no-cache, no-store");
//        response.setHeader("Pragma", "no-cache");
//        long time = System.currentTimeMillis();
//        response.setDateHeader("Last-Modified", time);
//        response.setDateHeader("Date", time);
//        response.setDateHeader("Expires", time);

        CaptchaUtil.out(request,response);



    }

}
