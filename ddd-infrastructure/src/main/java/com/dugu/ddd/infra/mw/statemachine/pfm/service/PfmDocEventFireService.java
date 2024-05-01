package com.dugu.ddd.infra.mw.statemachine.pfm.service;

import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocState;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;

/**
 * @author cihun
 * @date 2023-09-22 17:10
 */
public interface PfmDocEventFireService {
    /**
     * 状态触发
     *
     * @param state   状态
     * @param event   行为事件
     * @param context 系统上下文 {@link PfmDocStateContext}
     * @return PfmDocState to
     */
    PfmDocState fire(PfmDocState state, PfmDocEvent event, PfmDocStateContext context);
}
