package com.dugu.ddd.infra.mw.cache.redis.lock;

import com.dugu.ddd.infra.mw.cache.redis.RedisConfig;
import com.dugu.ddd.infra.mw.cache.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 分布式测试代码
 *
 * @author cihun
 * @date 2023-09-05 4:09 下午
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisLockHelperTest.Config.class)
public class RedisLockHelperTest {

    static String lockKey = "666";
    static String lockRequestID = "1";

    @Resource
    private RedisLockHelper redisLockHelper;

    public void testRedisLock() {

        try {
            Boolean lockFlag = redisLockHelper.lock(lockKey, lockRequestID, 2);
            log.info("加锁结果：{}", lockFlag);
            if (lockFlag) {
                try {
                    //20秒模拟处理业务代码时间
                    Thread.sleep(1000 * 5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            log.info("testRedisLock e---->", e);
        } finally {
            boolean unlockResp = redisLockHelper.unlock(lockKey, lockRequestID);
            log.info("释放锁结果:{}", unlockResp);
        }
    }

    public void testRedisLock2() {

        try {
            Boolean lockFlag = redisLockHelper.lock(lockKey, lockRequestID, 2);
            log.info("加锁结果：{}", lockFlag);
            if (lockFlag) {
                try {
                    //10秒模拟处理业务代码时间
                    Thread.sleep(1000 * 10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            log.info("testRedisLock e---->", e);
        } finally {
            boolean unlockResp = redisLockHelper.unlock(lockKey, lockRequestID);
            log.info("释放锁结果:{}", unlockResp);
        }
    }

    @Test
    public void mainTest() throws InterruptedException {
        log.info("下面测试两个线程同时，抢占锁的结果");
        Thread thread1 = new Thread(() -> {
            testRedisLock();
        });
        thread1.setName("我是线程1");
        Thread thread2 = new Thread(() -> {
            testRedisLock();
        });
        thread2.setName("我是线程2");

        //同时启动线程
        thread1.start();
        thread2.start();

        Thread.sleep(1000 * 20);
        log.info("-----------------我是一条分割线----------------");
        log.info("");
        log.info("");
        log.info("");


        log.info("下面是测试  一个线程获取锁成功后，由于业务执行时间超过了设置持有锁的时间，是否会把其他线程持有的锁给释放掉");
        Thread thread3 = new Thread(() -> {
            testRedisLock2();
        });
        thread3.setName("我是线程3");
        thread3.start();

        Thread.sleep(1000 * 1);//暂停一秒是为了让线程3获的到锁
        Thread thread4 = new Thread(() -> {
            testRedisLock();
        });
        thread4.setName("我是线程4");
        thread4.start();


        Thread.sleep(1000 * 30); // 测试线程sleep 30s
    }

    @Configuration
    @Import(value = {RedisConfig.class, RedisUtil.class, RedisAutoConfiguration.class})
    static class Config {
        @Bean
        public RedisLockHelper redisLockHelper() {
            return new RedisLockHelper();
        }
    }


}
