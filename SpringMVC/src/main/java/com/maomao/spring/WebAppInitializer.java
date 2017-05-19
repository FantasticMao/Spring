package com.maomao.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Servlet 3.0+ 版本提倡的无 Web.xml 配置中。
 * 在 Spring MVC 中实现 WebApplicationInitializer 接口即可。
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * {@link org.springframework.web.context.ContextLoaderListener} 加载应用中的其它 bean，如后端中间层和数据库组件。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * {@link org.springframework.web.servlet.DispatcherServlet} 加载包含 Web 组件的 bean，如控制器、视图解析器、处理器映射
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 将一个或多个路径映射到 DispatcherServlet
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement("/tmp/spring/uploads", 2 * 1024 * 1024, -1L, 0);
        registration.setMultipartConfig(multipartConfigElement);
    }

    /*
    // 实现 {@link org.springframework.web.WebApplicationInitializer} 方式
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //创建 WebApplicationContext
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //注册配置类
        context.register(WebConfig.class);
        //关联当前的 ServletContext
        context.setServletContext(servletContext);

        //注册 DispatcherServlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);

        //默认首页
        servletContext.setAttribute("welcome-file-list", "/index.html");
    }
    */
}
