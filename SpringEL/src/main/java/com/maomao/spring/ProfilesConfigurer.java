package com.maomao.spring;

import com.maomao.spring.profiles.Site;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:user.properties")
public class ProfilesConfigurer {
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
