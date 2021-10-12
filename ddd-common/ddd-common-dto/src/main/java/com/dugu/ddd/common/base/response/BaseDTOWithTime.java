package com.dugu.ddd.common.base.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 基础请求(带时间)
 *
 * @Author cihun
 * @Date 2021-10-09 7:27 下午
 */
@Getter
@Setter
@ToString
public class BaseDTOWithTime extends BaseDTOWithId {
    private static final long serialVersionUID = 5924508187864873059L;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
