package com.example.proxyproject.app.v2;

import com.example.proxyproject.app.v1.OrderRepositoryV1;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepositoryV2;
    
    public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }
    
    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}

