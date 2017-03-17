package com.maomao.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 使用 Profile 注解可指定不同环境下的 Spring 配置
 */
@Configuration
@ComponentScan
@Import({com.maomao.spring.profiles.Configurer.class,
        com.maomao.spring.task.Configurer.class,
        com.maomao.spring.schedule.Configurer.class,
        com.maomao.spring.condition.Configurer.class})
public class Application {

}
