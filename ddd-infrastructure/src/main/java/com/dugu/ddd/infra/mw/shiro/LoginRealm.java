package com.dugu.ddd.infra.mw.shiro;

import com.dugu.ddd.domain.login.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cihun
 * @date 2024/5/12 16:58
 */
public class LoginRealm  {
//        extends AuthorizingRealm {
    //public LoginRealm(String name) {
    //}
//    @Autowired
//    private UserLoginService userLoginService;
//
//    /**
//     * supports方法必须重写，这是shiro处理流程中的一部分，他会通过此方法判断realm是否匹配的正确
//     */
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JwtToken;
//    }
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//        LoginDataAutoToken token = (LoginDataAutoToken) auth;
//        serviceLog.info(token.getUsername() + "password auth start...");
//        User user = userLoginService.selectUserByName(token.getUsername());
//        if (user == null) throw new UnknownAccountException();
//        Object credentials = user.getPassword();
//        // save username and role to Attribute
//        ServletUtils.userNameRoleTo.accept(user.getUserName(), (int) user.getUserType());
//        return new SimpleAuthenticationInfo(user, credentials, super.getName());
//
//    }

}
