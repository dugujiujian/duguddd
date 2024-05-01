package com.dugu.ddd.infra.mw.cache.redis;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisUtilTest.Config.class)
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testExpire() throws Exception {
        redisUtil.set("aaaKey", "aaaValue");
        redisUtil.expire("aaaKey", 10);
        Assert.assertEquals(redisUtil.get("aaaKey"), "aaaValue");
        TimeUnit.SECONDS.sleep(10);
        Assert.assertNotEquals(redisUtil.get("aaaKey"), "aaaValue");

    }

    @Configuration
    @Import(value = {RedisConfig.class, RedisUtil.class, RedisAutoConfiguration.class})
   public static class Config {
    }


}