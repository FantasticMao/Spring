package com.maomao.spring;

import com.maomao.spring.domain.Department;
import com.maomao.spring.domain.Employee;
import com.maomao.spring.domain.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Employee employee = context1.getBean("employee", Employee.class);
        System.out.println(employee);

        ApplicationContext context2 = new AnnotationConfigApplicationContext(Application.class);
        Department department = context2.getBean("department", Department.class);
        System.out.println(department);

        Manager manager = context2.getBean("manager", Manager.class);
        System.out.println(manager);
    }
}
