package com.example.proxyproject.purepoxy.proxy;

import com.example.proxyproject.purepoxy.proxy.code.CacheProxy;
import com.example.proxyproject.purepoxy.proxy.code.ProxyPatternClient;
import com.example.proxyproject.purepoxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */
public class ProxyPatternTest {
    
    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        
        client.execute();
        client.execute();
        client.execute();
    }
    
    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy proxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(proxy);
        
        client.execute();
        client.execute();
        client.execute();
    }
}

