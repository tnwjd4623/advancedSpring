package com.example.proxyproject;

import com.example.proxyproject.config.AppV1Config;
import com.example.proxyproject.config.AppV2Config;
import com.example.proxyproject.config.v1_proxy.ConcreteProxyConfig;
import com.example.proxyproject.config.v1_proxy.InterfaceProxyConfig;
import com.example.proxyproject.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.example.proxyproject.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.example.proxyproject.trace.logtrace.LogTrace;
import com.example.proxyproject.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "com.example.proxyproject.app")
public class ProxyProjectApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProxyProjectApplication.class, args);
    }
    
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
