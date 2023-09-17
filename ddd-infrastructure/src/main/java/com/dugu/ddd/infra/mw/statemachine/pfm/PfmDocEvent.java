package ddd.infra.mw.statemachine.pfm;

/**
 * @author cihun
 * @date 2023-09-16 20:15
 */
public enum PfmDocEvent {
    /**
     * 计划启动
     */
    PLAN_START,
    /**
     * 提交目标
     */
    SUBMIT_OBJECT_ENTRY,
    /**
     * 自退
     */
    SELF_REFUND,
    /**
     * 主管退回
     */
    LEADER_REFUND,

    /**
     * 考核人退回
     */
    EMPLOYEE_REFUND,
    /**
     * 节点调整
     */
    DOC_NODE_ADJUST,
    ;
}
