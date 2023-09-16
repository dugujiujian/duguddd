package com.dugu.ddd.infra.mw.database;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.dugu.ddd.infra.mw.database.plugin.MpMetaObjectHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@MapperScan(basePackages = "com.dugu.ddd.infra.mw.database.mapper.dugut", sqlSessionTemplateRef = "dugutSqlSessionTemplate")
public class DugutDataSourceConfig {

    @Autowired
    private MpMetaObjectHandler mpMetaObjectHandler;
    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;


    @Bean(name = "dugutSqlSessionFactory")
    public SqlSessionFactory dugutSqlSessionFactory(@Qualifier("dugutDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPlugins(mybatisPlusInterceptor);
        //设置数据源
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dugut/*xml"));
        //这个的getResources指向的是你的mapper.xml文件，相当于在yml中配置的mapper-locations，此处配置了yml中就不用配置，或者说不会读取yml中的该配置。
        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
        //设置 字段自动填充处理
        globalConfig.setMetaObjectHandler(mpMetaObjectHandler);
        bean.setGlobalConfig(globalConfig);
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