package com.example.proxyproject.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class AImpl implements AInterface{
    @Override
    public String call() {
        log.info("a 호출");
        return "a";
    }
}

