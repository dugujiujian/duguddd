package com.dugu.ddd.domain.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录对象
 *
 * @author cihun
 * @date 2024/5/13 00:23
 */
@Data
@ApiModel(value = "登录对象", description = "登录对象")
public class LoginModel {
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    @ApiModelProperty(value = "身份证")
    private String idCard;
    @ApiModelProperty(value = "工号学号")
    private String workNo;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String captcha;
    @ApiModelProperty(value = "默认登录天数")
    private int loginDay;
}
