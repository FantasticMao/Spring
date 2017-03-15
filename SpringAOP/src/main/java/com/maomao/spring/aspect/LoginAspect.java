package com.maomao.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect 注解声明当前类是一个切面
 * Pointcut 注解定义切点的拦截规则
 * Before,After,Around 注解指定切点的Advice
 * 切点中成功拦截之处称为 JoinPoint
 */
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
