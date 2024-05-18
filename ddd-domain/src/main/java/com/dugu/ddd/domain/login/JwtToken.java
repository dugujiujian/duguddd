package com.dugu.ddd.domain.login;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 对token进行扩展
 *
 * @author cihun
 * @date 2024/5/12 23:22
 */
public class JwtToken implements AuthenticationToken {
    private static final long serialVersionUID = 852075219773986515L;
    private final String token;
    private final String type;

    public JwtToken(String token, String type) {
        this.type = type;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
 