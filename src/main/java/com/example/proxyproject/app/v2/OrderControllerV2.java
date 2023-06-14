package com.example.proxyproject.app.v2;

import com.example.proxyproject.app.v1.OrderServiceV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */

@Slf4j
@RequestMapping
@ResponseBody
//@Controller 는 Component Scan 이 포함되어 있기 때문에 제외함~ (수동 등록할거임)
public class OrderControllerV2 {
    private final OrderServiceV2 orderServiceV2;
    
    public OrderControllerV2(OrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }
    
    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderServiceV2.orderItem(itemId);
        return "ok";
    }
    
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}

