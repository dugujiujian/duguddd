package com.dugu.ddd.domain.dao.dugu.user;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 系统用户
 *
 * @author cihun
 * @date 2023-09-07 22:01
 */
@Data
@TableName("sys_user")
@Accessors(chain = true)
public class SysUserDO {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.UPDATE)
    private Date gmtModified;
    private Long createBy;
    private Long updateBy;
    private Long isDeleted;
    private String name;
    private String mobile;
    private String password;
}
