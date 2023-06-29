package com.example.proxyproject.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lee Su Jeong
 * @date 2023/06/29
 */

@Slf4j
public class ServiceImpl implements ServiceInterface{
    
    @Override
    public void save() {
        log.info("save 호출");
    }
    
    @Override
    public void find() {
        log.info("find 호출");
    }
}

