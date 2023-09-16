package com.dugu.ddd.infra.mw.database.mysql;

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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author cihun
 * @date 2023-09-08 10:51
 */
@Configuration
@MapperScan(basePackages = " com.dugu.ddd.infra.mw.database.mapper.dugu", sqlSessionTemplateRef = "duguSqlSessionTemplate")
public class DuguDataSourceConfig {

    @Autowired
    private MpMetaObjectHandler mpMetaObjectHandler;
    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Bean(name = "duguSqlSessionFactory")
    @Primary
    public SqlSessionFactory duguSqlSessionFactory(@Qualifier("duguDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // plugin
        bean.setPlugins(mybatisPlusInterceptor);
        //设置数据源
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dugu/*xml"));
        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
        //设置 字段自动填充处理
        globalConfig.setMetaObjectHandler(mpMetaObjectHandler);
        bean.setGlobalConfig(globalConfig);
        //这个的getResources指向的是你的mapper.xml文件，相当于在yml中配置的mapper-locations，此处配置了yml中就不用配置，或者说不会读取yml中的该配置。
        return bean.getObject();
    }

    @Bean(name = "duguTransactionManager")
    @Primary
    public DataSourceTransactionManager duguTransactionManager(@Qualifier("duguDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "duguSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate duguSqlSessionTemplate(@Qualifier("duguSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
