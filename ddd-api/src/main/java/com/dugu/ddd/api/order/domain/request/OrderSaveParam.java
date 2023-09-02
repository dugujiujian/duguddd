package com.dugu.ddd.api.order.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单保存参数
 *
 * @author cihun
 * @date 2022-05-05 11:45 上午
 */
@Getter
@Setter
@ToString
public class OrderSaveParam implements Serializable {

    private static final long serialVersionUID = 3216142755478195919L;
    /**
     * 商品ID
     */
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 买家ID
     */
    private Long buyerUserId;
    /**
     * 卖家ID
     */
    private Long sellerUserId;
}
