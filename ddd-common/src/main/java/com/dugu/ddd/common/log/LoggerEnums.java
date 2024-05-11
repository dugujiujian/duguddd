package com.dugu.ddd.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志枚举
 *
 * @author cihun
 * @date 2024/5/11 20:43
 */
public enum LoggerEnums {
    /**
     * 本应用服务日志
     */
    CONTROLLER_LOG("CONTROLLER_LOG"),
    ERROR_LOG("ERROR_LOG");


    private final Logger logger;

    LoggerEnums(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    public Logger getLogger() {
        return logger;
    }
}
