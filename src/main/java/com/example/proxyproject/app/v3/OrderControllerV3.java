package com.example.proxyproject.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */

@RestController
public class OrderControllerV3 {
    private final OrderServiceV3 orderServiceV3;
    
    public OrderControllerV3(OrderServiceV3 orderServiceV3) {
        this.orderServiceV3 = orderServiceV3;
    }
    
    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderServiceV3.orderItem(itemId);
        return "ok";
    }
    
    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
