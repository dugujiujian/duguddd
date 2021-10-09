package com.dugu.ddd.common.base.result.client;


import org.junit.Assert;
import org.junit.Test;

/**
 * @Author cihun
 * @Date 2021-10-06 10:05 下午
 */
public class ResultTest {


    @Test
    public void testSuccessAll() {
        String message = "成功";
        Result<Boolean> result = Result.success(message, true);
        Assert.assertTrue(result.isSuccess());
        Assert.assertEquals(message,result.getMessage());
    }

    @Test
    public void testSuccessNoData() {
        String message = "成功";
        Result<Boolean> result = Result.success(message);
        Assert.assertTrue(result.isSuccess());
        Assert.assertEquals(message,result.getMessage());
        System.out.println(result);
    }

    @Test
    public void testSuccessNoDataMessage() {
        Result<Boolean> result = Result.success();
        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void testFailAll() {
        String message = "失败";
        Result<Boolean> result = Result.fail("ERROR",message, false);
        Assert.assertFalse(result.isSuccess());
        Assert.assertEquals(message,result.getMessage());
    }





}