package com.dugu.ddd.api.order.domain.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cihun
 * @date 2022-05-05 11:42 上午
 */
@Getter
@Setter
@ToString
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -6575123176791522934L;

    private Long orderId;

    private Long buyerUserId;

    private Long sellerUserId;

    private Long productId;

    private String productTitle;


}
