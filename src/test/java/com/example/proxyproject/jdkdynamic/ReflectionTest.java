package com.example.proxyproject.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class ReflectionTest {
    
    @Test
    void reflection0() {
        Hello target = new Hello();
        
        // 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result={}", result1);
        // 종료
    
        // 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result2);
        // 종료
    }
    
    @Test
    void reflection1() throws Exception {
        // 클래스 메타정보
        Class classHello = Class.forName("com.example.proxyproject.jdkdynamic.ReflectionTest$Hello");
        
        Hello target = new Hello();
        
        // call A
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1={}", result1);
    
    
        // call A
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);
    }
    
    @Test
    void reflection2() throws Exception {
        // 클래스 메타정보
        Class classHello = Class.forName("com.example.proxyproject.jdkdynamic.ReflectionTest$Hello");
    
        Hello target = new Hello();
    
        // call A
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);
    
    
        // call A
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    
    }
    
    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }
    
    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }
        
        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}

