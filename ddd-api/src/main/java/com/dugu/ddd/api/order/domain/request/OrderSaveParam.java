package com.dugu.ddd.api.order.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cihun
 * @date 2022-05-05 11:45 上午
 */
@Getter
@Setter
@ToString
public class OrderSaveParam implements Serializable {

    private static final long serialVersionUID = 3216142755478195919L;
    private Long productId;
    private String productName;
    private Long buyerUserId;
    private Long sellerUserId;
}
