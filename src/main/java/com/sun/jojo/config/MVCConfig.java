package com.sun.jojo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 10:07
 */
@Configuration
public class MVCConfig  extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/websocket").setViewName("websocket");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/image/**").addResourceLocations("classpath:/static/image/");
//        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
//        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("/static/html/**").addResourceLocations("classpath:/static/html/");

        /**
         * 配置静态资源访问
         * 第一种：如下代码
         * 第二种： 在application.properties中添加配置 spring.mvc.static-path-pattern=/static/**
         */
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
