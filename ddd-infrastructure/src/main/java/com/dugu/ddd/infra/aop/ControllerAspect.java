package com.dugu.ddd.infra.aop;

import com.alibaba.fastjson.JSON;
import com.dugu.base.open.exception.BizException;
import com.dugu.base.open.result.Result;
import com.dugu.base.open.result.ResultCodeCommon;
import com.dugu.ddd.common.log.LogUtil;
import com.dugu.ddd.common.log.LoggerConst;
import com.dugu.ddd.common.log.LoggerEnums;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * controller层切面
 *
 * @author cihun
 * @date 2024/5/11 18:42
 */

@Component
@Aspect
@Slf4j
public class ControllerAspect {
    private static final Logger SERVICE_LOG = LoggerEnums.CONTROLLER_LOG.getLogger();
    private static final Logger ERROR_LOG = LoggerEnums.ERROR_LOG.getLogger();

    /**
     *
     */
    @Pointcut("execution(public * com.dugu.ddd.controller..*.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object logAndHandleException(ProceedingJoinPoint jp) {
        long start = System.currentTimeMillis();
        Object result = null;
        // 获取方法参数值数组
        Object[] args = jp.getArgs();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        boolean status = true;
        try {
            LogUtil.generateTraceId();
            result = jp.proceed();
            return result;
        } catch (BizException e) {
            result = new Result<>(e.getResultCode());
            return result;
        } catch (Throwable t) {
            status = false;
            String argsStr = "-";
            if (args != null) {
                argsStr = JSON.toJSONString(args);
                if (containPasswordKey(argsStr)) {
                    argsStr = "-";
                }
            }
            ERROR_LOG.error("args:{}", argsStr, t);
            result = new Result<>(ResultCodeCommon.SERVER_ERROR);
            return result;
        } finally {
            long costMs = System.currentTimeMillis() - start;
            this.resultLog(method, costMs, status, args, result);
            LogUtil.clearTraceId();
        }
    }

    private void resultLog(Method method, long cost, boolean status, Object[] args, Object result) {
        String argStr = "-";
        String resultStr = "-";
        if (args != null) {
            argStr = JSON.toJSONString(args);
        }
        if (result != null) {
            resultStr = JSON.toJSONString(result);
        }
        argStr = argStr.length() > LoggerConst.LOG_MAX_CONTENT_SIZE ? argStr.substring(0, LoggerConst.LOG_MAX_CONTENT_SIZE) : argStr;
        resultStr = resultStr.length() > LoggerConst.LOG_MAX_CONTENT_SIZE ? resultStr.substring(0, LoggerConst.LOG_MAX_CONTENT_SIZE) : resultStr;
        if (containPasswordKey(argStr)) {
            argStr = "-";
        }
        SERVICE_LOG.info("{}|{}|{}|{}|{}", method.getDeclaringClass().getName() + "." + method.getName(), cost + "ms", status, argStr, resultStr);
    }

    private boolean containPasswordKey(String args) {
        if (args != null && args.contains(LoggerConst.PASS_MASK)) {
            return true;
        }
        return false;
    }

}
