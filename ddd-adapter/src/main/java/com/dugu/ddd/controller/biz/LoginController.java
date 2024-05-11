package com.dugu.ddd.controller.biz;

import com.dugu.base.open.exception.BizException;
import com.dugu.base.open.result.Result;
import com.dugu.ddd.common.rc.UserResultCode;
import com.dugu.ddd.domain.dto.request.LoginUserReq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录
 *
 * @author cihun
 * @date 2024/5/10 12:39
 */

@Controller
public class LoginController {


    @ResponseBody
    @RequestMapping("/login")
    public Result<String> index(@RequestBody LoginUserReq user) {
        if (!user.getUsername().equals("aaa")) {
            throw new BizException(UserResultCode.USER_NOT_EXIST);
        }
        if (user.getPassword().equals("000000")) {
            int a = -1 / 0;
        }
        return Result.success();
    }

    @RequestMapping("/logon")
    public String login() {
        return "login.html";
    }

}