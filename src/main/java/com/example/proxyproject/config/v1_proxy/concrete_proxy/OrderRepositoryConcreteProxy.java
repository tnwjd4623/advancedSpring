package com.example.proxyproject.config.v1_proxy.concrete_proxy;

import com.example.proxyproject.app.v2.OrderRepositoryV2;
import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */


public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    
    private final OrderRepositoryV2 target;
    private final LogTrace trace;
    
    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }
    
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.request()");
            target.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}

