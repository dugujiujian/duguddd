package com.dugu.ddd.common.base.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 基础输出(带ID)
 *
 * @Author cihun
 * @Date 2021-10-09 7:30 下午
 */
@Getter
@Setter
@ToString(callSuper = true)
public class BaseDTOWithId extends BaseDTO implements Serializable {
    private static final long serialVersionUID = -6689437959342155091L;
    private Long id;
}
