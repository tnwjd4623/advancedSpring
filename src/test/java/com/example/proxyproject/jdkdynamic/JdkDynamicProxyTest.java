package com.example.proxyproject.jdkdynamic;

import com.example.proxyproject.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class JdkDynamicProxyTest {
    
    /*
        동적 프록시
        각 Interface 마다 클래스를 따로 만들지 않아도 사용할 수 있다.
     */
    @Test
    void dynamicA() {
        AInterface target = new AImpl();
    
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
    
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
        proxy.call();
        
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
    
    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);
        proxy.call();
        
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}

