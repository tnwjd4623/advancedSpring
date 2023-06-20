package com.example.proxyproject.config.v1_proxy.interface_proxy;

import com.example.proxyproject.app.v1.OrderRepositoryV1;
import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/06/19
 */

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {
    
    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;
    
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        
        try {
            status = logTrace.begin("OrderRepository.request()");
            
            //target
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
        
    }
}

