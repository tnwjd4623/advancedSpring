package com.example.proxyproject.config.v2_dynamicproxy.handler;

import com.example.proxyproject.trace.TraceStatus;
import com.example.proxyproject.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lee Su Jeong
 * @date 2023/06/21
 */

@Slf4j
public class LogTraceFilterHandler implements InvocationHandler {
    
    private final Object target;
    private final LogTrace logTrace;
    private final String[] patterns;
    
    public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] patterns) {
        this.target = target;
        this.logTrace = logTrace;
        this.patterns = patterns;
    }
    
    
    // no-log가 로그가 출력되는 문제가 있다
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        String methodName = method.getName();
        if (!PatternMatchUtils.simpleMatch(patterns, methodName)) {
            return method.invoke(target, args);
        }
        
        TraceStatus status = null;
    
        try {
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            status = logTrace.begin(message);
            
            //target
            Object result = method.invoke(target, args);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}

