package com.dugu.ddd.api.order.domain;

import com.dugu.ddd.api.order.domain.request.OrderSaveParam;

/**
 * 订单接口
 *
 * @author cihun
 * @date 2022-05-05 11:41 上午
 */
public interface OrderService {

    boolean payOrder(OrderSaveParam param);
}
