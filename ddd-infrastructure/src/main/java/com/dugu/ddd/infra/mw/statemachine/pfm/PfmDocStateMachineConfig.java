package com.dugu.ddd.infra.mw.statemachine.pfm;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author cihun
 * @date 2023-09-16 20:24
 */
@Configuration
public class PfmDocStateMachineConfig {

    final static String MACHINE_ID = "pfmDocStateMachine";

    @PostConstruct
    private void initStateMachine() {

    }
}
