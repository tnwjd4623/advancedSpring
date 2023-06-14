package com.example.proxyproject.config;

import com.example.proxyproject.app.v1.*;
import com.example.proxyproject.app.v2.OrderControllerV2;
import com.example.proxyproject.app.v2.OrderRepositoryV2;
import com.example.proxyproject.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lee Su Jeong
 * @date 2023/05/11
 */
@Configuration
public class AppV2Config {
    
    @Bean
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServiceV2());
    }
    
    @Bean
    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoryV2());
    }
    
    @Bean
    public OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }
}

