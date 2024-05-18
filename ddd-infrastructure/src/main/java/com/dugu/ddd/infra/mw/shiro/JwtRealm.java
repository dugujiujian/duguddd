package com.dugu.ddd.infra.mw.shiro;

import com.dugu.ddd.domain.login.JwtToken;
import com.dugu.ddd.infra.util.ServletUtils;
import com.dugu.ddd.infra.util.TokenUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author cihun
 * @date 2024/5/12 22:47
 */
public class JwtRealm  {

//    public JwtRealm(String name) {
//        setName(name);
//    }
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JwtToken;
//    }
//
//    // 给当前用户授权，只有在访问的接口上配置了shiro的权限相关的注解的时候才会进入此方法
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        UserEnum.Type userEnum = EnumValue.dataValueOf(
//                UserEnum.Type.class,
//                ServletUtils.userNameRoleFrom.get().getUserRole()
//        );
//        Set<String> roles = new HashSet<>();
//        roles.add(userEnum.getDesc());
//        // 授权角色如果有其他的权限则都已此类的方式授权
//        authorizationInfo.setRoles(roles);
//        return authorizationInfo;
//    }
//
//    // 验证此次request携带的token是否正确，如果正确解析当前token，并存入上下文中
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//        // verify token
//        String token = (String) auth.getCredentials();
//        TokenUtils.verify(token);
//        TupleNameRole tupleNameRole = TokenUtils.tokenDecode(token);
//        ServletUtils.userNameRoleTo.accept(tupleNameRole.getUsername(), tupleNameRole.getUserRole());
//        return new SimpleAuthenticationInfo(token, token, ((JwtDataAutoToken) auth).getName());
//    }

}
