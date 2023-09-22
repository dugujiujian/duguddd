package com.dugu.ddd.infra.mw.statemachine.pfm.service.impl;

import com.alibaba.cola.statemachine.Condition;
import com.dugu.ddd.infra.mw.statemachine.pfm.PfmDocStateContext;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocConditionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author cihun
 * @date 2023-09-22 16:41
 */
@Slf4j
@Service
public class PfmDocConditionServiceImpl implements PfmDocConditionService {
    @Override
    public Condition<PfmDocStateContext> passCondition() {
        return context -> {
            if (context != null) {
                log.info("pass");
                return true;
            }
            log.info("reject");
            return false;
        };
    }
}
