package com.dugu.ddd.infra.mw.cache.redis.lock;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author cihun
 * @date 2023-09-05 3:41 下午
 */
@Component
public class RedisLockHelper {

    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param value      请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean lock(String lockKey, String value, int expireTime) {
        return redisTemplate.opsForValue().setIfAbsent(lockKey, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 释放分布式锁
     * <p>
     * 1. 首先获取锁对应的value值，检查是否与requestId相等，如果相等则删除锁（解锁）
     * 2. 原子性
     * </p>
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean unlock(String lockKey, String requestId) {
        String luaScript = "if redis.call('exists', KEYS[1]) > 0 then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Boolean> redisScript = new DefaultRedisScript<>(luaScript, Boolean.class);
        Boolean releaseStatus = (Boolean) redisTemplate.execute(redisScript, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        return releaseStatus != null && releaseStatus;

    }
}