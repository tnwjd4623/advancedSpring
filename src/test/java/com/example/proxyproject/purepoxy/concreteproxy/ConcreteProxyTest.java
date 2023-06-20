package com.example.proxyproject.purepoxy.concreteproxy;

import com.example.proxyproject.purepoxy.concreteproxy.code.ConcreteClient;
import com.example.proxyproject.purepoxy.concreteproxy.code.ConcreteLogic;
import com.example.proxyproject.purepoxy.concreteproxy.code.TimeProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */

// 구체 클래스 프록시
@Slf4j
public class ConcreteProxyTest {
    
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }
    
    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy proxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(proxy);
        client.execute();
    }
}

