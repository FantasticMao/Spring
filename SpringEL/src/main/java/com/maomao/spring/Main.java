package com.maomao.spring;

import com.maomao.spring.condition.OsService;
import com.maomao.spring.el.User;
import com.maomao.spring.profiles.Site;
import com.maomao.spring.task.MyTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static void el() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    static void profiles1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("pro");
        context.register(Application.class);
        context.refresh();
        Site site = context.getBean("proSite", Site.class);
        System.out.println(site);
    }

    static void profiles2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(Application.class);
        context.refresh();
        Site site = context.getBean("devSite", Site.class);
        System.out.println(site);
    }


    static void task() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MyTask task = context.getBean("myTask", MyTask.class);
        for (int i = 0; i < 10; i++) {
            task.task1(i);
            task.task2(i);
        }
    }

    static void scheduledTask() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
    }

    static void condition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        OsService service = context.getBean(OsService.class);
        service.service();
    }

    public static void main(String[] args) {
        condition();
    }
}
