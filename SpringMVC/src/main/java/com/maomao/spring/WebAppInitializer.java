package com.maomao.spring;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Servlet 3.0+ 版本提倡的无 Web.xml 配置中。
 * 在 Spring MVC 中实现 WebApplicationInitializer 接口即可。
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 创建 WebApplicationContext
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册配置类
        context.register(WebApp.class);
        // 关联当前的 ServletContext
        context.setServletContext(servletContext);

        // 注册 DispatcherServlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);

        // 默认首页
        servletContext.setAttribute("welcome-file-list", "/index.html");
    }
}
