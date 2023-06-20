package com.example.proxyproject.config.v1_proxy.interface_proxy;

import com.example.proxyproject.app.v1.OrderControllerV1;
import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/06/19
 */

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {
    
    private final OrderControllerV1 target;
    private final LogTrace logTrace;
    
    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        
        try {
            status = logTrace.begin("OrderController Request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
    
    @Override
    public String noLog() {
        return target.noLog();
    }
}

