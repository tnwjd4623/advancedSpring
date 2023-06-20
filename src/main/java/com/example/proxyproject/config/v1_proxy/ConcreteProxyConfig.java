package com.example.proxyproject.config.v1_proxy;

import com.example.proxyproject.app.v2.OrderControllerV2;
import com.example.proxyproject.app.v2.OrderRepositoryV2;
import com.example.proxyproject.app.v2.OrderServiceV2;
import com.example.proxyproject.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import com.example.proxyproject.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import com.example.proxyproject.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import com.example.proxyproject.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */

@Configuration
public class ConcreteProxyConfig {
    
    
    
    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 orderControllerV2 = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(orderControllerV2, logTrace);
    }
    
    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 orderServiceV2 = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(orderServiceV2, logTrace);
    }
    
    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryV2 = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryV2, logTrace);
    }
}

