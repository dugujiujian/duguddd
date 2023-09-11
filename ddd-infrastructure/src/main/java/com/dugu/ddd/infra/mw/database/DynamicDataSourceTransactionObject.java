package com.dugu.ddd.infra.mw.database;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cihun
 * @date 2023-09-11 19:59
 */
public class DynamicDataSourceTransactionObject   {

    private Map<Object, PlatformTransactionManager> targetTransactionManagers;

    private Map<Object, DefaultTransactionStatus> transactionStatusMap = new HashMap<>();



    public void setTargetTransactionManagers(Map<Object, PlatformTransactionManager> targetTransactionManagers) {
        this.targetTransactionManagers = targetTransactionManagers;
        for (Map.Entry<Object, PlatformTransactionManager> entry : targetTransactionManagers.entrySet()) {
            Object key = entry.getKey();
            PlatformTransactionManager transactionManager = entry.getValue();
            transactionStatusMap.put(key, (DefaultTransactionStatus) transactionManager.getTransaction(new DefaultTransactionDefinition()));
        }
    }

    public Map<Object, PlatformTransactionManager> getTargetTransactionManagers() {
        return targetTransactionManagers;
    }

    public DefaultTransactionStatus getTransactionStatus() {
        return transactionStatusMap.get(DbContextHolder.getCurrentDsStr());
    }
}
