package com.dugu.ddd.infra.mw.shiro;

import com.dugu.ddd.common.constants.Constants;
import com.dugu.ddd.domain.login.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT过滤器
 *
 * @author cihun
 * @date 2024/5/13 00:01
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 判断是否允许访问
     *
     * @param request     ServletRequest
     * @param response    ServletResponse
     * @param mappedValue mappedValue
     * @return 是否成功
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            throw new AuthenticationException("Token失效，请重新登录", e);
        }
    }

    /**
     * execute login
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(Constants.X_ACCESS_TOKEN);
        try {
            JwtToken jwtToken = new JwtToken(token, null);
            // validate user permission
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (AuthenticationException e) {

        }
        return false;
    }

    /**
     * support across domains
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));

        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
