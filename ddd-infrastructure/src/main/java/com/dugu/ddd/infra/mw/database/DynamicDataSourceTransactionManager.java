package com.dugu.ddd.infra.mw.database;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

import java.util.Map;

/**
 * @author cihun
 * @date 2023-09-11 19:59
 */
public class DynamicDataSourceTransactionManager extends AbstractPlatformTransactionManager {

    private Map<Object, PlatformTransactionManager> targetTransactionManagers;

    @Override
    protected Object doGetTransaction() throws TransactionException {
        DynamicDataSourceTransactionObject dynamicDataSourceTransactionObject = new DynamicDataSourceTransactionObject();
        dynamicDataSourceTransactionObject.setTargetTransactionManagers(targetTransactionManagers);
        return dynamicDataSourceTransactionObject;
    }

    @Override
    protected void doBegin(Object o, TransactionDefinition transactionDefinition) throws TransactionException {
        DynamicDataSourceTransactionObject transactionObject = (DynamicDataSourceTransactionObject) o;
        for (PlatformTransactionManager transactionManager : transactionObject.getTargetTransactionManagers().values()) {
            transactionManager.getTransaction(transactionDefinition);
        }
    }

    @Override
    protected void doCommit(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        DynamicDataSourceTransactionObject transactionObject = (DynamicDataSourceTransactionObject) defaultTransactionStatus.getTransaction();
        for (PlatformTransactionManager transactionManager : transactionObject.getTargetTransactionManagers().values()) {
            transactionManager.commit(transactionObject.getTransactionStatus());
        }
    }

    @Override
    protected void doRollback(DefaultTransactionStatus defaultTransactionStatus) throws TransactionException {
        DynamicDataSourceTransactionObject transactionObject = (DynamicDataSourceTransactionObject) defaultTransactionStatus.getTransaction();
        for (PlatformTransactionManager transactionManager : transactionObject.getTargetTransactionManagers().values()) {
            transactionManager.rollback(transactionObject.getTransactionStatus());
        }
    }

    public Map<Object, PlatformTransactionManager> getTargetTransactionManagers() {
        return targetTransactionManagers;
    }

    public void setTargetTransactionManagers(Map<Object, PlatformTransactionManager> targetTransactionManagers) {
        this.targetTransactionManagers = targetTransactionManagers;
    }
}
