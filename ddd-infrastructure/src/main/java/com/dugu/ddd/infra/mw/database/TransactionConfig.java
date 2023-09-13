package com.dugu.ddd.infra.mw.database;

/**
 * @author cihun
 * @date 2023-09-11 19:18
 */
//@Aspect
//@Configuration
//@Slf4j
public class TransactionConfig {
//    private static final int TX_METHOD_TIMEOUT = 300;
//    private static final String AOP_POINTCUT_EXPRESSION = "execution(*com.dugu.ddd.service..*Service.*(..))";
//    @Autowired
//    private ConfigurableApplicationContext applicationContext;
//
//    @Bean(name = "txAdvice")
//    public TransactionInterceptor txAdvice() {
//
//        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//        // 只读事务，不做更新操作
//        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
//        readOnlyTx.setReadOnly(true);
//        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//
//        // 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务
//        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
//        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        requiredTx.setTimeout(TX_METHOD_TIMEOUT);
//        Map<String, TransactionAttribute> txMap = new HashMap<>();
//        txMap.put("add*", requiredTx);
//        txMap.put("save*", requiredTx);
//        txMap.put("insert*", requiredTx);
//        txMap.put("create*", requiredTx);
//        txMap.put("update*", requiredTx);
//        txMap.put("batch*", requiredTx);
//        txMap.put("modify*", requiredTx);
//        txMap.put("delete*", requiredTx);
//        txMap.put("remove*", requiredTx);
//        txMap.put("exec*", requiredTx);
//        txMap.put("set*", requiredTx);
//        txMap.put("do*", requiredTx);
//        txMap.put("get*", readOnlyTx);
//        txMap.put("query*", readOnlyTx);
//        txMap.put("find*", readOnlyTx);
//        txMap.put("*", requiredTx);
//        source.setNameMap(txMap);
//        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager(), source);
//        return txAdvice;
//    }
//
//    @Bean
//    public Advisor txAdviceAdvisor(@Qualifier("txAdvice") TransactionInterceptor txAdvice) {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
//        return new DefaultPointcutAdvisor(pointcut, txAdvice);
//    }
//
//    /**
//     * 自定义 事务管理器 管理我们自定义的 MyRoutingDataSource 数据源
//     *
//     * @return {@link DataSourceTransactionManager}
//     */
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager transactionManager() {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(applicationContext.getBean(DynamicDataSource.class));
//        return transactionManager;
//    }
}
