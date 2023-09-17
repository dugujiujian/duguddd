package com.dugu.ddd.common.base.result;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author cihun
 * @date 2022-04-29 4:24 下午
 */
@Getter
@Setter
@ToString
public class BaseResult {
    /**
     * 是否成功
     */
    private Boolean success = Boolean.FALSE;
    /**
     * 编码
     */
    private String code;
    /**
     * 消息
     */
    private String message;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
