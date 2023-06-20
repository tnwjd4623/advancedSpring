package com.example.proxyproject.config.v1_proxy.concrete_proxy;

import com.example.proxyproject.app.v2.OrderServiceV2;
import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */

public class OrderServiceConcreteProxy extends OrderServiceV2 {
    
    private final OrderServiceV2 target;
    private final LogTrace logTrace;
    
    public OrderServiceConcreteProxy(OrderServiceV2 orderServiceV2, LogTrace logTrace) {
        super(null); // 구체 클래스 단점
        this.target = orderServiceV2;
        this.logTrace = logTrace;
    }
    
    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
    
        try {
            status = logTrace.begin("OrderService Request()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}

