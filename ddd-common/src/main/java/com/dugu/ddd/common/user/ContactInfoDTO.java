package com.dugu.ddd.common.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 联系信息
 *
 * @author cihun
 * @date 2021-10-09 7:19 下午
 */
@Getter
@Setter
@ToString
public class ContactInfoDTO implements Serializable {
    private static final long serialVersionUID = -8230510503104730864L;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobilePhone;
}
