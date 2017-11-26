package com.maomao.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * IndexController
 *
 * @author maodh
 * @since 2017/7/9
 */
@RestController
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map index(HttpServletRequest request) {
        return Collections.emptyMap();
    }
}
