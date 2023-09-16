package com.dugu.ddd.infra.mw.database;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author cihun
 * @date 2023-09-11 17:08
 */
@Slf4j
@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean(name = "duguDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dugu")
    public DataSource duguDataSource() {
        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

    @Bean(name = "dugutDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dugut")
    public DataSource dugutDataSource() {
        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }
}
