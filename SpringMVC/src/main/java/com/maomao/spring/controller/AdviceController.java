package com.maomao.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler
    @ResponseBody
    public String exception(Exception e) {
        // 此处直接拼接 JSON，会产生双引号的编码问题
        return "{\"statue\":false,\"message\":\"" + e.getMessage() + "\"}";
    }

    @InitBinder
    public void bind(WebDataBinder webDataBinder) {
        // ...
    }

    @ModelAttribute
    public void attribute(Model model) {
        model.addAttribute("author", "Mao Mao");
    }
}
