package com.dugu.ddd.domain.dao.dugu.user;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户
 *
 * @author cihun
 * @date 2023-09-07 22:01
 */
@Data
@TableName("sys_user")
public class SysUserDO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private Long createBy;
    private Long updateBy;
    private Long isDeleted;
    private String name;
    private String mobile;
    private String password;
}
