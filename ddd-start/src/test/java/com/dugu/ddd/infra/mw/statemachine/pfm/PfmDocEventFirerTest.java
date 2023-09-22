package com.dugu.ddd.infra.mw.statemachine.pfm;

import com.dugu.ddd.infra.app.service.user.UserServiceImplTest;
import com.dugu.ddd.infra.mw.cache.redis.RedisConfig;
import com.dugu.ddd.infra.mw.cache.redis.RedisUtil;
import com.dugu.ddd.infra.mw.cache.redis.RedisUtilTest;
import com.dugu.ddd.infra.mw.cache.redis.lock.RedisLockHelper;
import com.dugu.ddd.infra.mw.eventbus.pfmdoc.AsyncEventConfiguration;
import com.dugu.ddd.infra.mw.eventbus.pfmdoc.NoticeListener;
import com.dugu.ddd.infra.mw.message.NoticeEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocActionService;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocConditionService;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocEventFireService;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.impl.PfmDocActionServiceImpl;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.impl.PfmDocConditionServiceImpl;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.impl.PfmDocEventFireServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author cihun
 * @date 2023-09-22 16:43
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PfmDocEventFirerTest.Config.class,  RedisUtilTest.Config.class,UserServiceImplTest.Config.class})
public class PfmDocEventFirerTest {

    @Autowired
    private PfmDocEventFireService pfmDocEventFireService;

    @Test
    public void testPrepareToObjectEntry() {
        PfmDocState from = PfmDocState.PREPARE;
        PfmDocStateContext ctx = PfmDocStateContext.builder()
                .docId("1")
                .operateTime(new Date())
                .operator(1L)
                .event(new NoticeEvent())
                .build();
        PfmDocState toState = pfmDocEventFireService.fire(from, PfmDocEvent.PLAN_START, ctx);
        Assert.assertNotEquals(from, toState);
    }

    @Test
    public void testTranslate() {
        PfmDocState from = PfmDocState.PREPARE;
        PfmDocStateContext ctx = PfmDocStateContext.builder()
                .docId("1")
                .operateTime(new Date())
                .operator(1L)
                .event(new NoticeEvent())
                .build();
        PfmDocState toState = pfmDocEventFireService.fire(from, PfmDocEvent.PLAN_START, ctx);
        Assert.assertNotEquals(from, toState);
    }

    @Configuration
    @Import(value = {RedisLockHelper.class, PfmDocStateMachineConfig.class, NoticeListener.class,
            AsyncEventConfiguration.class})
   public static class Config {
        @Bean
        public PfmDocConditionService pfmDocConditionService() {
            return new PfmDocConditionServiceImpl();
        }

        @Bean
        public PfmDocActionService pfmDocActionService() {
            return new PfmDocActionServiceImpl();
        }

        @Bean
        public PfmDocEventFireService pfmDocEventFireService() {
            return new PfmDocEventFireServiceImpl();
        }

    }

}