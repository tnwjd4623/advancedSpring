package com.example.proxyproject.app.v3;

import com.example.proxyproject.app.v2.OrderRepositoryV2;
import org.springframework.stereotype.Service;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */

@Service
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV3;
    
    public OrderServiceV3(OrderRepositoryV3 orderRepositoryV3) {
        this.orderRepositoryV3 = orderRepositoryV3;
    }
    
    public void orderItem(String itemId) {
        orderRepositoryV3.save(itemId);
    }
}

