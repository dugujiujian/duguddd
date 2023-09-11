package com.dugu.ddd.domain.repository;

/**
 * 聚合根的Marker接口
 *
 * @author cihun
 * @date 2023-09-11 20:49
 */
public interface Aggregate<ID extends Identifier> extends Entity<ID> {
}