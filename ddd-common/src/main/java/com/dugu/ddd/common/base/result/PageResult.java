package com.dugu.ddd.common.base.result;

import com.dugu.ddd.common.utils.MainUtil;
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
     * 当前页数
     */
    private Integer pageIndex;
    /**
     * 页码
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private long totalCount;
    /**
     * 当前页面结果
     */
    private List<T> data;

    public static <T> PageResult<T> success(List<T> data, Long totalCount, Integer pageIndex, Integer pageSize) {
        PageResult<T> result = new PageResult<>();
        result.setSuccess(true);
        result.setPageIndex(pageIndex);
        result.setPageSize(pageSize);
        result.setTotalCount(totalCount);
        result.setData(data);
        return result;
    }

    /**
     * 分页（无数据）
     *
     * @param pageSize 页码
     * @param <T>      返回对象
     * @return 对象
     */
    public static <T> PageResult<T> success(Integer pageSize) {
        PageResult<T> result = new PageResult<>();
        result.setSuccess(true);
        result.setPageIndex(1);
        result.setPageSize(pageSize);
        result.setTotalCount(0L);
        return result;
    }

    /**
     * 分页（无数据,默认10条）
     *
     * @param <T> 返回对象
     * @return 对象
     */
    public static <T> PageResult<T> success() {
        PageResult<T> result = new PageResult<>();
        result.setSuccess(true);
        result.setPageIndex(1);
        result.setPageSize(MainUtil.DEFAULT_PAGE_SIZE);
        result.setTotalCount(0L);
        return result;
    }


    public Integer getPageIndex() {
        if (this.pageIndex == null || this.pageIndex < 0) {
            this.pageIndex = 1;
        }
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize < 0 || this.pageSize > 100) {
            this.pageSize = MainUtil.DEFAULT_PAGE_SIZE;
        }
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
