package com.dugu.ddd.infra.mw.database.enums;

import lombok.Getter;

/**
 * 公用枚举
 *
 * @author cihun
 * @date 2023-09-11 17:12
 */
public enum DatabaseCommonEnum {
    ;

    /**
     * 数据库
     */
    public enum DsType {
        DS_DUGU("dugu"), DS_DUGUT("dugut");
        @Getter
        private String value;

        DsType(String value) {
            this.value = value;
        }
    }

}
