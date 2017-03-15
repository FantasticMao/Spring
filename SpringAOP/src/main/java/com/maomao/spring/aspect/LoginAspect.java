package com.maomao.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("@annotation(com.maomao.spring.annotation.CheckLogin)")
    public void loginPointCut() {

    }

    @Before("loginPointCut()")
    public void beforeLogin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        boolean isLogin = (boolean) args[0];
        System.out.println("check login " + (isLogin ? "OK" : "fail"));
    }
}
