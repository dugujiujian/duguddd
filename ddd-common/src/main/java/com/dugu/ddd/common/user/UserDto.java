package com.dugu.ddd.common.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cihun
 * @date 2023-09-17 12:50
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//Include.Include.ALWAYS 默认
//Include.NON_DEFAULT 属性为默认值不序列化
//Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
//Include.NON_NULL 属性为NULL 不序列化
@Getter
@Setter
@ToString
public class UserDto implements Serializable {

    private static final long serialVersionUID = -1014197574966810100L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 联系信息
     */
    private ContactInfoDto contactInfo;
}
