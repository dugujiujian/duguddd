package com.dugu.ddd.infra.mw.statemachine.pfm;

import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocActionService;
import com.dugu.ddd.infra.mw.statemachine.pfm.service.PfmDocConditionService;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author cihun
 * @date 2023-09-16 20:24
 */
@Configuration
public class PfmDocStateMachineConfig {

    public static final ImmutableCollection<PfmDocState> TO_OBJECT_ENTRY = ImmutableList.of(
            PfmDocState.PREPARE,
            PfmDocState.OBJECT_APPROVE,
            PfmDocState.EMPLOYEE_SCORE,
            PfmDocState.INVITE_SCORE,
            PfmDocState.LEADER_SCORE
    );
    public final static String MACHINE_ID = "pfmDocStateMachine";
    public final static String PFM_DOC_STATE_LOCK_KEY = "lock";

    @Autowired
    private PfmDocConditionService pfmDocConditionService;
    @Autowired
    private PfmDocActionService pfmDocActionService;

    @PostConstruct
    private void initStateMachine() {
        buildStateMachine();
    }

    private void buildStateMachine() {
        StateMachineBuilder<PfmDocState, PfmDocEvent, PfmDocStateContext> builder = StateMachineBuilderFactory.create();
        builder.externalTransitions()
                .fromAmong(TO_OBJECT_ENTRY.toArray(new PfmDocState[0]))
                .to(PfmDocState.OBJECT_ENTRY)
                .on(PfmDocEvent.PLAN_START)
                .when(pfmDocConditionService.passCondition())
                .perform(pfmDocActionService.doAction());

        builder.build(PfmDocStateMachineConfig.MACHINE_ID);

        // StateMachine<PfmDocState, PfmDocEvent, PfmDocStateContext> stateMachine = StateMachineFactory.get(PfmDocStateMachineConfig.MACHINE_ID);
        // Generate the state machine graph for visualization
        // String plantUMLStr = stateMachine.generatePlantUML();
        //System.out.println(plantUMLStr);
    }
}
