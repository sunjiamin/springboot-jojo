package com.sun.jojo.config;

import com.sun.jojo.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-24 16:46
 */
@Configuration
@ServletComponentScan
public class AppConfiguration   extends WebMvcConfigurerAdapter
{
    //自定义静态资源文件路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/sunjiamin/img/**").addResourceLocations("classpath:/static/image/");
        registry.addResourceHandler("/sunjiamin/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/sunjiamin/page/**").addResourceLocations("classpath:/static/html/");
    }

//    @Bean
//    public ServletRegistrationBean registrationBean(){
//        return new ServletRegistrationBean(new TestServlet(),"/testservlet");
//    }
}