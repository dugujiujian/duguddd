package com.dugu.ddd.infra.mw.statemachine.pfm.service.impl;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;
import com.dugu.ddd.infra.mw.cache.redis.lock.RedisLockHelper;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocState;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateMachineConfig;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocEventFireService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cihun
 * @date 2023-09-22 17:11
 */
@Slf4j
@Service
public class PfmDocEventFireServiceImpl implements PfmDocEventFireService {

    @Autowired
    private RedisLockHelper redisLockHelper;

    @Override
    public PfmDocState fire(PfmDocState state, PfmDocEvent event, PfmDocStateContext ctx) {
        if(state==null){
            log.info("no from state");
            return null;
        }
        String key = StringUtils.isNotEmpty(ctx.getLockKey()) ? ctx.getLockKey() : PfmDocStateMachineConfig.PFM_DOC_STATE_LOCK_KEY;
        boolean isLock = redisLockHelper.lock(key, ctx.getDocId(), 1);
        if(!isLock){
            log.error("can't catch lock");
            return null;
        }
        try {
            StateMachine<PfmDocState, PfmDocEvent, PfmDocStateContext> stateMachine = StateMachineFactory.get(PfmDocStateMachineConfig.MACHINE_ID);
            return stateMachine.fireEvent(state, event, ctx);
        } finally {
            redisLockHelper.unlock(key, ctx.getDocId());
        }
    }
}
