package com.example.proxyproject.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee Su Jeong
 * @date 2023/05/11
 */

@RequestMapping // 스프링은 @Controller 또는 @RequestMapping 이 있어야 컨트롤러로 인식한다. 인터페이스에서 사용 가능
@ResponseBody // HTTP 메세지 컨버터를 사용해서 응답한다. 인터페이스에서 사용 가능
public interface OrderControllerV1 {
    
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);
    
    @GetMapping("/v1/no-log")
    String noLog();
    
}

