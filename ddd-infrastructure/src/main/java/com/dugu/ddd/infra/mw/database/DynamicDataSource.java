package com.dugu.ddd.infra.mw.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源路由
 *
 * @author cihun
 * @date 2023-09-11 17:18
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getCurrentDsStr();
    }
}


