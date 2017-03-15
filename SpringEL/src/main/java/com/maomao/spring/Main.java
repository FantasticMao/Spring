package com.maomao.spring;

import com.maomao.spring.domain.Site;
import com.maomao.spring.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static void run1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    static void run2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("pro");
        context.register(Application.class);
        context.refresh();
        Site site = context.getBean("proSite", Site.class);
        System.out.println(site);
    }

    static void run3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(Application.class);
        context.refresh();
        Site site = context.getBean("devSite", Site.class);
        System.out.println(site);
    }

    public static void main(String[] args) {
        run3();
    }
}
