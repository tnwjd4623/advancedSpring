package com.example.proxyproject.purepoxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/15
 */

@Slf4j
public class RealComponent implements Component {
    
    @Override
    public String operation() {
        log.info("RealComponent 실행");
        return "data";
    }
}

