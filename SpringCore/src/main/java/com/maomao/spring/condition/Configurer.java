package com.maomao.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class Configurer {

    @Bean
    @Conditional(WindowsCondition.class)
    public OsService windowsService() {
        return new WindowsService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public OsService linuxService() {
        return new LinuxService();
    }
}
