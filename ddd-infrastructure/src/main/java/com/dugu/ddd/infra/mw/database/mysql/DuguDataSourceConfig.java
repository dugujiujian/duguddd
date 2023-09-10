package com.dugu.ddd.infra.mw.database.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.datasource.dugu.url}")
    private String url;
    @Value("${spring.datasource.dugu.username}")
    private String username;
    @Value("${spring.datasource.dugu.password}")
    private String password;
    @Value("${spring.datasource.dugu.driver-class-name}")
    private String className;
    @Autowired
    private MybatisConfiguration mybatisConfiguration;

    @Primary
    @Bean(name = "duguDataSource")
    //@ConfigurationProperties(prefix = "spring.datasource.dugu")
    public DataSource duguDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(className);
        druidDataSource.setName("duguDataSource");
        return druidDataSource;
    }


    @Bean(name = "duguSqlSessionFactory")
    @Primary
    public SqlSessionFactory duguSqlSessionFactory(@Qualifier("duguDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(mybatisConfiguration);
        //设置数据源
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dugu/*xml"));
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
