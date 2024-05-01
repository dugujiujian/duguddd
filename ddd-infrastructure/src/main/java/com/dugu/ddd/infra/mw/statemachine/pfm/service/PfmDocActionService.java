package com.dugu.ddd.infra.mw.statemachine.pfm.service;

import com.alibaba.cola.statemachine.Action;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocEvent;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocState;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;

/**
 * @author cihun
 * @date 2023-09-22 16:45
 */
public interface PfmDocActionService {
    /**
     * 状态机行为处理
     *
     * @return 后续处理动作
     */
    Action<PfmDocState, PfmDocEvent, PfmDocStateContext> doAction();
}
