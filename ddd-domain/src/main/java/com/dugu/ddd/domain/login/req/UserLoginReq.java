package com.dugu.ddd.domain.login.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 登录用户信息
 *
 * @author cihun
 * @date 2024/5/10 12:41
 */
@Getter
@Setter
@ToString
public class UserLoginReq implements Serializable {
    private static final long serialVersionUID = -184434695533790558L;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
