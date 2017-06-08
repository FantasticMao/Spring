package com.maomao.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 更简洁地来讲，REST 就是将资源的状态以最合适客户端的形式，从服务端转移到客户端（或者反过来）。
 * 基于对 REST 的这种观点，所以我尽量避免使用诸如 REST 服务、REST Web 服务或类似的术语，这些术语会不恰当地强调行为。
 * 相反，我更愿意强调 REST 面向资源的本质，并讨论 RESTful 资源。
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

}
