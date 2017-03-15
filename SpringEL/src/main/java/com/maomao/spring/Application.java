package com.maomao.spring;

import com.maomao.spring.domain.Site;
import org.springframework.context.annotation.*;

/**
 * 使用 Profile 注解可指定不同环境下的 Spring 配置
 */
@Configuration
@ComponentScan
@PropertySource("classpath:user.properties")
public class Application {

    @Bean
    @Profile("pro")
    public Site proSite() {
        return new Site("www.maomao.com");
    }

    @Bean
    @Profile("dev")
    public Site devSite() {
        return new Site("www.maomao.net");
    }
}
