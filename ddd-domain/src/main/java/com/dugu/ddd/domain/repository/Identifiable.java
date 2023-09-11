package com.dugu.ddd.domain.repository;

/**
 * @author cihun
 * @date 2023-09-11 20:50
 */
public interface Identifiable<ID extends Identifier> {
    /**
     * 获取ID对象
     *
     * @return {@link Identifier}
     */
    ID getId();
}