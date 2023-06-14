package com.example.proxyproject.purepoxy.proxy.code;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */
public class ProxyPatternClient {
    
    private Subject subject;
    
    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }
    
    public void execute() {
        subject.operation();
    }
}

