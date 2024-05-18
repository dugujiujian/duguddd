package com.dugu.ddd.application.user;

/**
 * @author cihun
 * @date 2024/5/12 23:05
 */
public interface UserManager {
    /**
     * 账号密码登录
     *
     * @param username 账号密码
     * @param password 密码
     */
    void login(String username, String password);
}
