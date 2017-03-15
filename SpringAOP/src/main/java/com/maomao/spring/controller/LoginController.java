package com.maomao.spring.controller;

import com.maomao.spring.annotation.CheckLogin;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @CheckLogin
    public void login(boolean isLogin) {
        System.out.println("login ...");
    }
}
