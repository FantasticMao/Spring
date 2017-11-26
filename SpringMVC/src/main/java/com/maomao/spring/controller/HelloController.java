package com.maomao.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. @Controller 注解声明当前类是 Spring MVC 的控制器
 * 2. @RestController 注解组合了 @Controller 和 @ResponseBody
 * 3. @RequestMapping 注解映射 Web 请求 (访问路径和参数)，至处理类或处理方法上
 * 4. @RequestBody 注解允许 Request 参数在 Request 体中，而不是直接放置在 URL 后缀中
 * 5. @ResponseBody 注解允许将返回值放置在 Response 体中
 * 6. @PathVariable 注解用于接受 URL 路径参数
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value = "/hello",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, // 对应 request 中的 Content-Type
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // 对应 request 中的 Accept
    @ResponseBody
    public Map hello(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("message", "hello");
        request.getSession().setAttribute("name", "maomao");
        return map;
    }

}
