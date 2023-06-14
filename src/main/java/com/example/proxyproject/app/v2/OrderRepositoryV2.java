package com.example.proxyproject.app.v2;

import com.example.proxyproject.app.v1.OrderRepositoryV1;

/**
 * @author Lee Su Jeong
 * @date 2023/06/12
 */
public class OrderRepositoryV2 {
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
