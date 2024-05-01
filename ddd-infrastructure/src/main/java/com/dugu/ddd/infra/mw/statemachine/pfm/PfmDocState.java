package com.dugu.ddd.infra.mw.statemachine.pfm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author cihun
 * @date 2023-09-16 17:22
 */
public enum PfmDocState {

    /**
     * 未开始
     */
    PREPARE("prepare"),
    /**
     * 目标设置
     */
    OBJECT_ENTRY("object_entry"),
    /**
     * 目标审批
     */
    OBJECT_APPROVE("object_approve"),
    /**
     * 自评
     */
    EMPLOYEE_SCORE("employee_score"),
    /**
     * 自评
     */
    INVITE_SCORE("employee_score"),
    /**
     * 升级评分
     */
    LEADER_SCORE("employee_score"),
    /**
     * 评分审批
     */
    RESULT_APPROVE("result_approve"),
    /**
     * 待确认
     */
    RESULT_INTERVIEW("result_interview"),
    /**
     * 确认
     */
    RESULT_PUBLIC("result_public"),
    /**
     * 结束
     */
    END("end"),

    ;
    @Getter
    @Setter
    private String code;

    PfmDocState(String code) {
        this.code = code;
    }

}
