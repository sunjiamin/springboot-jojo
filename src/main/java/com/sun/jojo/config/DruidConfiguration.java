package com.sun.jojo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: druid/login.html
 * 开启Druid监控功能 开启监控功能，可以在应用运行的过程中，通过监控提供的多维度数据来分析使用数据库的运行情况，
 * 从而可以调整程序设计，以便于优化数据库的访问性能。
 * 项目运行成功后，我们要访问Druid的监控界面，访问地址：127.0.0.1:8080/druid/login.html
 * @author sunjiamin
 * @date 2018-04-27 14:10
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置IP白名单
        registrationBean.addInitParameter("allow","127.0.0.1");
        //设置控制台管理用户
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");

        //是否可以重置数据
        registrationBean.addInitParameter("resetEnable","false");

        return registrationBean;
    }
}
