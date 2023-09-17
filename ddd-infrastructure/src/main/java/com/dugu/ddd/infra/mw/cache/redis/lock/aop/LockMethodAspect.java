package com.dugu.ddd.infra.mw.cache.redis.lock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author cihun
 * @date 2023-09-05 9:56 上午
 */
//@Aspect
//@Component
public class LockMethodAspect {

    private Logger logger = LoggerFactory.getLogger(LockMethodAspect.class);

    @Around("@annotation(com.dugu.ddd.infra.mw.cache.redis.lock.aop.RedisLock)")
    public Object around(ProceedingJoinPoint joinPoint) {
//        Jedis jedis = jedisUtil.getJedis();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//
//        RedisLock redisLock = method.getAnnotation(RedisLock.class);
//        String value = UUID.randomUUID().toString();
//        String key = redisLock.key();
//        try {
//            final boolean islock = redisLockHelper.lock(jedis,key, value, redisLock.expire(), redisLock.timeUnit());
//            logger.info("isLock : {}",islock);
//            if (!islock) {
//                logger.error("获取锁失败");
//                throw new RuntimeException("获取锁失败");
//            }
//            try {
//                return joinPoint.proceed();
//            } catch (Throwable throwable) {
//                throw new RuntimeException("系统异常");
//            }
//        }  finally {
//            logger.info("释放锁");
//            redisLockHelper.unlock(jedis,key, value);
//            jedis.close();
//        }
        return null;
    }
}