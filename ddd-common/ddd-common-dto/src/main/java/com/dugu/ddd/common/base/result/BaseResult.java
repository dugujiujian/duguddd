package com.dugu.ddd.common.base.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

/**
 * @Author cihun
 * @Date 2021-10-07 9:29 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class BaseResult {

    /**
     * 成功与否标志
     */
    private boolean success;
    /**
     * 返回错误码
     */
    private String errorCode;
    /**
     * 返回消息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


//    @Override
//    public String toString() {
//        return "BaseResult{" +
//                "success=" + success +
//                ", errorCode='" + errorCode + '\'' +
//                ", message='" + message + '\'' +
//                '}';
//    }
}
