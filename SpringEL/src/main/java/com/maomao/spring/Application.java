package com.maomao.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 使用 Profile 注解可指定不同环境下的 Spring 配置
 */
@Configuration
@ComponentScan
@Import({ProfilesConfigurer.class, TaskConfigurer.class, ScheduledTaskConfigurer.class})
public class Application {

}
