package com.dugu.ddd.common.base.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果返回
 *
 * @author cihun
 * @date 2021-10-07 9:26 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PageResult<T> extends BaseResult implements Serializable {

    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前页面结果
     */
    private List<T> data;
}
