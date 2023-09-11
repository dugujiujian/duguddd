package com.dugu.ddd.infra.mw.database;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author cihun
 * @date 2023-09-07 14:50
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@AutoConfigureAfter({DataSourceConfiguration.class})
@MapperScan(basePackages = {"com.dugu.ddd.infra.mw.database.mapper.dugu", "com.dugu.ddd.infra.mw.database.mapper.dugut"})
public class MybatisPlusConfig {

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setMaxLimit(-1L);
        paginationInterceptor.setDbType(DbType.MYSQL);
        //分页查询超过最大页码 显示第一页
        paginationInterceptor.setOverflow(true);
        // 开启 count 的 join 优化,只针对部分 left join
        return paginationInterceptor;
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.setInterceptors(Collections.singletonList(paginationInnerInterceptor()));
        return mybatisPlusInterceptor;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus.configuration")
    public MybatisConfiguration mybatisConfiguration() {
        return new MybatisConfiguration();
    }
}
