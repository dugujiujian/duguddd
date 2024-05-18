package com.dugu.ddd.infra.util;

import com.dugu.ddd.common.constants.Constants;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Servlet工具类
 *
 * @author cihun
 * @date 2024/5/12 12:31
 */
public final class ServletUtils {
    private ServletUtils() {
    }

    private static final int SCOPE = RequestAttributes.SCOPE_REQUEST;

    private static final Supplier<ServletRequestAttributes> servletRequestAttributes = () ->
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    private static final Supplier<HttpServletRequest> request = () -> servletRequestAttributes.get().getRequest();

    private static final Supplier<HttpServletResponse> response = () -> servletRequestAttributes.get().getResponse();

    private static final Consumer<String> saveUsernameToAttribute = (name) ->
            servletRequestAttributes.get().setAttribute(Constants.USER_NAME, name, SCOPE);

    private static final Supplier<String> usernameFromAttribute = () ->
            (String) servletRequestAttributes.get().getAttribute(Constants.USER_NAME, SCOPE);

    private static final Consumer<Integer> saveUserRoleToAttribute = (role) ->
            servletRequestAttributes.get().setAttribute(Constants.USER_ROLE, role, SCOPE);

    private static final Supplier<Integer> userRoleFromAttribute = () ->
            (Integer) servletRequestAttributes.get().getAttribute(Constants.USER_ROLE, SCOPE);

    /**
     * get token form current request
     */
    public static Supplier<String> tokenFromRequest = () -> request.get().getHeader(Constants.X_ACCESS_TOKEN);

    /**
     * save current user name and role to attribute
     */
    public static BiConsumer<String, Integer> userNameRoleTo = (name, role) -> {
        saveUsernameToAttribute.accept(name);
        saveUserRoleToAttribute.accept(role);
    };

    /**
     * get user name and role from attribute
     */
//    public static Supplier<TupleNameRole> userNameRoleFrom = () ->
//            new TupleNameRole(usernameFromAttribute.get(), userRoleFromAttribute.get());

    /**
     * add message to response header
     */
    public static BiConsumer<String, String> addHeader = (key, value) -> response.get().addHeader(key, value);
}

