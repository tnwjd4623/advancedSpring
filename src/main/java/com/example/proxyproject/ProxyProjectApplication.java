package com.example.proxyproject;

import com.example.proxyproject.config.AppV1Config;
import com.example.proxyproject.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "com.example.proxyproject.app")
public class ProxyProjectApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProxyProjectApplication.class, args);
    }
    
}
