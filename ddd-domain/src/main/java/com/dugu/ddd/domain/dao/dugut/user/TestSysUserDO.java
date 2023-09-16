package com.dugu.ddd.domain.dao.dugut.user;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统用户
 *
 * @author cihun
 * @date 2023-09-07 22:01
 */
@Data
@TableName("test_sys_user")
public class TestSysUserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long isDeleted;
    private String name;
    private String sex;
}
