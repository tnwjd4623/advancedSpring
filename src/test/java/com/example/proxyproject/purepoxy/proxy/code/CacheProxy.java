package com.example.proxyproject.purepoxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */

@Slf4j
public class CacheProxy implements Subject {
    
    private Subject target;
    private String cacheValue;
    
    public CacheProxy(Subject target) {
        this.target = target;
    }
    
    @Override
    public String operation() {
        log.info("프록시 호출");
        
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        
        return cacheValue;
    }
}

