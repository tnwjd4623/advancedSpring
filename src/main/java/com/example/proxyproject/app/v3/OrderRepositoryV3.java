package com.example.proxyproject.app.v3;

import org.springframework.stereotype.Repository;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */
@Repository
public class OrderRepositoryV3 {
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("IllegalStateException");
        }
        
        sleep(1000);
    }
    
    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

