package com.example.proxyproject.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/29
 */

@Slf4j
public class ConcreteService {
    
    public void call() {
        log.info("call 호출");
    }
}

