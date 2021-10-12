package com.dugu.ddd.common.base.result;

import lombok.ToString;

import java.io.Serializable;

/**
 * client接口返回结果定义
 *
 * @author cihun
 * @date 2021-10-06
 */
@ToString(callSuper = true)
public class Result<T> extends BaseResult implements Serializable {

    private static final long serialVersionUID = 185581488616744992L;

    /**
     * 数据
     */
    private T data;

    /**
     * 成功提示
     *
     * @param message
     * @param data
     * @param <T>
     * @return
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
     * @param message
     * @param <T>
     * @return
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
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        return result;
    }

    /**
     * 错误提示
     *
     * @param errorCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String errorCode, String message) {
        return fail(errorCode, message, null);
    }

    /**
     * 错误提示
     *
     * @param errorCode
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String errorCode, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setData(data);
        result.setErrorCode(errorCode);
        result.setMessage(message);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
