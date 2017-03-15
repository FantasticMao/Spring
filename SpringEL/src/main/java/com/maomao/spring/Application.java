package com.maomao.spring;

import com.maomao.spring.domain.Site;
import org.springframework.context.annotation.*;

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
