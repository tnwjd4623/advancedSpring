package com.example.proxyproject.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
    private final Object target;
    
    public TimeInvocationHandler(Object target) {
        this.target = target;
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        
        Object result = method.invoke(target, args);
        
        long endTime = System.currentTimeMillis();
        
        log.info("TimeProxy 종료 resultTime={}", endTime - startTime);
        return result;
    }
}

