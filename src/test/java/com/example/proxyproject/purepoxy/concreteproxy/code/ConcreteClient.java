package com.example.proxyproject.purepoxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;

/**
 * @author Lee Su Jeong
 * @date 2023/06/20
 */

public class ConcreteClient {
    
    private ConcreteLogic concreteLogic;
    
    public ConcreteClient(ConcreteLogic logic) {
        this.concreteLogic = logic;
    }
    
    public void execute() {
        concreteLogic.operation();
    }
}

