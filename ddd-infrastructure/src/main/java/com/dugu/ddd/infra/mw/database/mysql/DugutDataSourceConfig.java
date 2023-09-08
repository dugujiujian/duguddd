package com.dugu.ddd.infra.mw.database.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author cihun
 * @date 2023-09-08 10:52
 */

@Configuration
@MapperScan(basePackages = " com.dugu.ddd.infra.mw.database.mapper.dugut", sqlSessionTemplateRef = "dugutSqlSessionTemplate")
public class DugutDataSourceConfig {

    @Value("${spring.datasource.dugut.url}")
    private String url;
    @Value("${spring.datasource.dugut.username}")
    private String username;
    @Value("${spring.datasource.dugut.password}")
    private String password;
    @Value("${spring.datasource.dugut.driver-class-name}")
    private String className;

    @Bean(name = "dugutDataSource")
    public DataSource dugutDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(className);
        druidDataSource.setName("dugutDataSource");
        return druidDataSource;
    }


    @Bean(name = "dugutSqlSessionFactory")
    public SqlSessionFactory dugutSqlSessionFactory(@Qualifier("dugutDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置数据源
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dugut/*xml"));
        //这个的getResources指向的是你的mapper.xml文件，相当于在yml中配置的mapper-locations，此处配置了yml中就不用配置，或者说不会读取yml中的该配置。
        return bean.getObject();
    }

    @Bean(name = "dugutTransactionManager")
    public DataSourceTransactionManager dugutTransactionManager(@Qualifier("dugutDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dugutSqlSessionTemplate")
    public SqlSessionTemplate dugutSqlSessionTemplate(@Qualifier("dugutSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}