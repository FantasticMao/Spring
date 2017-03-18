package com.maomao.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @PathVariable String name) {
        mv.addObject("name", name);
        mv.setViewName("index");
        return mv;
    }
}
