package com.dugu.ddd.infra.mw.database;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源配置
 *
 * @author cihun
 * @date 2023-09-11 17:08
 */
@Slf4j
//@Configuration
public class DataSourceConfiguration {
//
//    @Value("${spring.datasource.druid.defaultDS}")
//    private String defaultDs;
//
//    @Primary
//    @Bean(name = "duguDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.dugu")
//    public DataSource duguDataSource() {
//        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        //DbContextHolder.addDataSource(DatabaseCommonEnum.DsType.DS_DUGU.getValue(), druidDataSource);
//        return druidDataSource;
//    }
//
//    @Bean(name = "dugutDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.dugut")
//    public DataSource dugutDataSource() {
//        DataSource druidDataSource = DruidDataSourceBuilder.create().build();
//       // DbContextHolder.addDataSource(DatabaseCommonEnum.DsType.DS_DUGUT.getValue(), druidDataSource);
//        return druidDataSource;
//    }

//    @Bean(name = "dynamicDataSource")
//    public DynamicDataSource dynamicDataSource(@Qualifier("duguDataSource") DataSource duguDataSource, @Qualifier("dugutDataSource") DataSource dugutDataSource) {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        Map<Object, Object> targetDataResourcesMap = new HashMap<>(2);
//        targetDataResourcesMap.put(DatabaseCommonEnum.DsType.DS_DUGU.getValue(), duguDataSource);
//        targetDataResourcesMap.put(DatabaseCommonEnum.DsType.DS_DUGUT.getValue(), dugutDataSource);
//        //设置默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(duguDataSource);
//        dynamicDataSource.setTargetDataSources(targetDataResourcesMap);
//        DbContextHolder.setDefaultDs(defaultDs);
//        return dynamicDataSource;
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "dynamicDataSource") DataSource dynamicDataSource) throws Exception {
//        log.info("==========>开始注入 MybatisSqlSessionFactoryBean");
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
//        Set<Resource> result = new LinkedHashSet<>(16);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            result.addAll(Lists.newArrayList(resolver.getResources("classpath:mapper/dugu/*xml")));
//            result.addAll(Lists.newArrayList(resolver.getResources("classpath:mapper/dugut/*xml")));
//        } catch (IOException e) {
//            log.error("获取【classpath:mapper/*/*.xml,classpath:config/mapper/*/*.xml】资源错误!异常信息:{}", e.getMessage(), e);
//        }
//        sqlSessionFactoryBean.setMapperLocations(result.toArray(new org.springframework.core.io.Resource[0]));
//        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
//        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
////        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
//        //设置 字段自动填充处理
////        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
////        bean.setGlobalConfig(globalConfig);
////        log.info("==========>注入 MybatisSqlSessionFactoryBean 完成!");
//        return sqlSessionFactoryBean.getObject();
//    }
}
