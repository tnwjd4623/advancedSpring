package com.example.proxyproject.app.v1;

/**
 * @author Lee Su Jeong
 * @date 2023/05/11
 */
public class OrderRepositoryV1Impl implements OrderRepositoryV1{
    @Override
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

