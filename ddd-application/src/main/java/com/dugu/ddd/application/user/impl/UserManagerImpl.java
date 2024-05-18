package com.dugu.ddd.application.user.impl;

import com.dugu.ddd.application.user.UserManager;
import com.dugu.ddd.domain.login.JwtToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


/**
 * @author cihun
 * @date 2024/5/12 23:05
 */

@Service
public class UserManagerImpl implements UserManager {
    @Override
    public void login(String username, String password) {
        // Use shiro to verify the username and password
        Subject subject = SecurityUtils.getSubject();
        JwtToken token = new JwtToken(username, password);
        subject.login(token);
    }
}
