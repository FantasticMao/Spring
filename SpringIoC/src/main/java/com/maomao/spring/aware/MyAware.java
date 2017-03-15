package com.maomao.spring.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 使用 Spring Aware 可以使容器中的 Bean 感知 Spring 框架的存在，即可获取 Spring 框架所提供的资源。
 */
@Component
public class MyAware implements BeanNameAware, BeanClassLoaderAware {
    private String name;
    private ClassLoader classLoader;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public String getName() {
        return name;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }
}
