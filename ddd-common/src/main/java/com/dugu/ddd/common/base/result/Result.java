package com.dugu.ddd.common.base.result;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * client接口返回结果定义
 *
 * @author cihun
 * @date 2021-10-06
 */
@Getter
@Setter
public class Result<T> extends BaseResult implements Serializable {

    private static final long serialVersionUID = 185581488616744992L;
    /**
     * 数据
     */
    private T data;

}
