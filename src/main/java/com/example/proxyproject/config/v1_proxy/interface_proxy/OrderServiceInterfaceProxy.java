package com.example.proxyproject.config.v1_proxy.interface_proxy;

import com.example.proxyproject.app.v1.OrderServiceV1;
import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/06/19
 */

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {
    
    private final OrderServiceV1 target;
    private final LogTrace logTrace;
    
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

