package com.maomao.spring;

import com.maomao.spring.domain.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class Application {

    @Bean
    @Scope("prototype")
    public Department department() {
        Department department = new Department();
        department.setName("技术研发部");
        return department;
    }
}
