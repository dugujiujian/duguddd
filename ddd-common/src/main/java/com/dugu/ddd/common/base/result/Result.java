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

    /**
     * 成功提示
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     泛对象
     * @return 泛对象
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * 成功提示
     *
     * @param message 消息
     * @param <T>     泛对象
     * @return 泛对象
     */
    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    /**
     * 成功提示
     *
     * @param <T> 泛对象
     * @return 泛对象
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        return result;
    }

}
