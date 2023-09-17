package com.dugu.ddd.common.base.request;

import com.dugu.ddd.common.utils.MainUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sun.applet.Main;

import java.io.Serializable;

/**
 * @author cihun
 * @date 2023-09-17 12:53
 */
@Getter
@Setter
@ToString
public class BasePageRequest  implements Serializable {
    private static final long serialVersionUID = -4042482745623503365L;
    /**
     * 当前页数
     */
    private Integer pageIndex;
    /**
     * 页码
     */
    private Integer pageSize;

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