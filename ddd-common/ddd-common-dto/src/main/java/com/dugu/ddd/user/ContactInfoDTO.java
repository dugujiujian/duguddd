package com.dugu.ddd.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author cihun
 * @Date 2021-10-09 7:19 下午
 */
@Getter
@ToString
@Setter
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
