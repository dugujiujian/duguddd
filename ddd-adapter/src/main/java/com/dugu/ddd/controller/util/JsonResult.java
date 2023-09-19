package com.dugu.ddd.controller.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cihun
 * @date 2023-09-18 20:25
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class JsonResult<T> implements Serializable {
    /**
     * 状态码，例如：200
     */
    private Integer state;
    /**
     * 消息，例如："登录失败，用户名不存在"
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /**
     * 数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private JsonResult() {
    }

    public static JsonResult<Void> ok() {
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setState(200);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult<Void> fail(int statusCode, String message) {
        JsonResult<Void> jsonResult = new JsonResult<>();
        jsonResult.setState(statusCode);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}