package com.maomao.spring.domain;

import org.springframework.stereotype.Component;

@Component
public class Site {
    private String domain;

    public Site() {
    }

    public Site(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Site{" +
                "domain='" + domain + '\'' +
                '}';
    }
}
