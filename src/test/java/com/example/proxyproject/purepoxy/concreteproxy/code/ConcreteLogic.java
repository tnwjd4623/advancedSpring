package com.example.proxyproject.purepoxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */

@Slf4j
public class ConcreteLogic {
    
    public String operation() {
        log.info("ConcreteLogic 실행");
        return "data";
    }
}

