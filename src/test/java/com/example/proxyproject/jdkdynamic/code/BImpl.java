package com.example.proxyproject.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class BImpl implements BInterface{
    @Override
    public String call() {
        log.info("b 호출");
        return "b";
    }
}

