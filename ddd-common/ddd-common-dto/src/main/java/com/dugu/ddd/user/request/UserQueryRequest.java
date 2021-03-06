package com.dugu.ddd.user.request;

import com.dugu.ddd.common.base.request.BasePageRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author cihun
 * @Date 2021-10-09 7:39 下午
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserQueryRequest extends BasePageRequest {
    private static final long serialVersionUID = 3994266217355167834L;
    private String name;
}
