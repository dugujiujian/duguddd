package com.dugu.ddd.infra.mw.statemachine.pfm.service;

import com.alibaba.cola.statemachine.Condition;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;

/**
 * @author cihun
 * @date 2023-09-22 16:38
 */
public interface PfmDocConditionService {
    /**
     * 通过条件
     *
     * @return 返回条件结果 {@link Condition}
     */
    Condition<PfmDocStateContext> passCondition();
}
