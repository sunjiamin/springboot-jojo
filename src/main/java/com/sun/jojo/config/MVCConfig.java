package com.sun.jojo.config;

import com.sun.jojo.annotation.CustomerArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 10:07
 */
@Configuration
public class MVCConfig  extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomerArgumentResolver());
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
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

    /**
     * 添加跨域访问配置
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        /**
         *  addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
         *  allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
         *  allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，
         *      如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
         *  allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
         */
//       registry.addMapping("/**")
//               .allowedMethods("*")
//               .allowedOrigins("*")
//               .allowedHeaders("*");
    }
}
