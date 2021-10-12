package com.dugu.ddd.common.base.result;


import com.dugu.ddd.common.base.request.BasePageRequest;
import com.dugu.ddd.common.utils.DDDUtil;
import com.dugu.ddd.user.request.UserQueryRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author cihun
 * @Date 2021-10-09 7:32 下午
 */
public class PageResultTest {


    @Test
    public void testUserQueryRequest() {
        UserQueryRequest userQueryRequest=new UserQueryRequest();
        userQueryRequest.setName("赵");
        userQueryRequest.setPageSize(10);
        userQueryRequest.setPageIndex(1);
        Assert.assertTrue(userQueryRequest.getPageSize()== DDDUtil.DEFAULT_PAGE_SIZE);
        Assert.assertTrue(userQueryRequest.getPageIndex()== 1);
        System.out.println(userQueryRequest);
    }

    @Test
    public void testRequest() {
        BasePageRequest basePageRequest=new BasePageRequest();
        Assert.assertTrue(basePageRequest.getPageSize()== DDDUtil.DEFAULT_PAGE_SIZE);
        Assert.assertTrue(basePageRequest.getPageIndex()== 1);
        System.out.println(basePageRequest);
    }


    @Test
    public void testSuccess() {
        PageResult<Void> result = PageResult.success();
        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getPageSize() == DDDUtil.DEFAULT_PAGE_SIZE);
        System.out.println(result);
    }

    @Test
    public void testSuccessAll() {
        PageResult<Long> result = PageResult.success(Arrays.asList(1L, 2L), 20L, 2, 20);
        Assert.assertTrue(result.isSuccess());
        Assert.assertTrue(result.getPageIndex() == 2);
        Assert.assertTrue(result.getTotalCount() == 20L);
        System.out.println(result);
    }


}