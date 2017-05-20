package com.maomao.spring.controller;

import com.maomao.spring.form.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 使用 JSR-303，支持表单校验，
 * 需要导入 {@link javax.validation.constraints} 的实现包，如 Hibernate ...
 */
@Controller
public class ValidateController {

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public String validate(@Valid User user, Errors errors) {
        System.out.println(user);
        if (errors.hasErrors()) {
            return "{\"error\"}";
        }
        return "{\"success\"}";
    }
}
