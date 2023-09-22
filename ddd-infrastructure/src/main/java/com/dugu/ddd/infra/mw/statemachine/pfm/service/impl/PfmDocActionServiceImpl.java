package com.dugu.ddd.infra.mw.statemachine.pfm.service.impl;

import com.alibaba.cola.statemachine.Action;
import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.message.NoticeEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocState;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author cihun
 * @date 2023-09-22 16:47
 */
@Slf4j
@Service
public class PfmDocActionServiceImpl implements PfmDocActionService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private UserService userService;


    /**
     * 通过执行动作
     *
     * @return Action
     */
    @Override
    public Action<PfmDocState, PfmDocEvent, PfmDocStateContext> doAction() {
        return (from, to, event, ctx) -> {
            log.info(ctx.getOperator() + " is operating ! from:" + from + " to:" + to + " on:" + event);
            userService.transactionTest();
            NoticeEvent noticeEvent = ctx.getEvent();
            applicationEventPublisher.publishEvent(noticeEvent);
        };
    }
}
