package com.dugu.ddd.domain.repository;

/**
 * 实体类的Marker接口
 *
 * @author cihun
 * @date 2023-09-11 20:51
 */
public interface Entity<ID extends Identifier> extends Identifiable<ID> {
}
