package com.dugu.ddd.common.base.result;

import com.dugu.ddd.common.utils.DDDUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果返回
 *
 * @Author cihun
 * @Date 2021-10-07 9:26 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
public class PageResult<T> extends BaseResult implements Serializable {
    private static final long serialVersionUID = -4274392560170032211L;
    /**
     * 数据
     */
    private List<T> data;
    /**
     * 总计
     */
    private Long totalCount;
    /**
     * 当前页码
     */
    private Integer pageIndex;
    /**
     * 页码数
     */
    private Integer pageSize;

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
     * @param pageSize
     * @param <T>
     * @return
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
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> success() {
        PageResult<T> result = new PageResult<>();
        result.setSuccess(true);
        result.setPageIndex(1);
        result.setPageSize(DDDUtil.DEFAULT_PAGE_SIZE);
        result.setTotalCount(0L);
        return result;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
