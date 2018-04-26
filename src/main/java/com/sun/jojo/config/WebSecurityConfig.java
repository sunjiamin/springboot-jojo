package com.sun.jojo.config;

import com.sun.jojo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 10:18
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 完成自定义认证实体注入
     * @return
     */
    @Bean
    UserDetailsService userService()
    {
        return new UserService();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService());
//    }

    /**
     * 在securityConfig类下加入密码加密,在数据库中存的密码也是要经过这个加密的才能匹配上
     * @param auth
     * @throws Exception
     */
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService()).passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable()
                 .authorizeRequests()
                 .anyRequest().authenticated()//所有请求必须登陆后才能访问
                 .and()
                     .formLogin()
                     .loginPage("/login")
                     //.defaultSuccessUrl("/home")
                     .failureUrl("/login?error")
                     //登陆界面直接访问
                     .permitAll()
                 .and()
                 .logout()
                 .permitAll();//注销界面直接访问
    }
}
