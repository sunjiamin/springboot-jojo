package com.sun.jojo.config.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-07-25 10:13
 */
@Configuration
@EnableConfigurationProperties(AutoConfigTestProperties.class)//需要引入的配置
@ConditionalOnClass(AutoConfigTestService.class) //哪个类需要自动注入属性
public class AutoConfigTestAutoConfiguration {

    @Autowired
    AutoConfigTestProperties autoConfigTestProperties;

    @Bean
    @ConditionalOnMissingBean(AutoConfigTestService.class)//个配置就是SpringBoot可以优先使用自定义Bean的核心所在，如果没有我们的自定义Bean那么才会自动配置一个新的Bean
    AutoConfigTestService auto(){
        AutoConfigTestService autoConfigTestService = new AutoConfigTestService();
        autoConfigTestService.setMsg(autoConfigTestProperties.getMsg());
        return  autoConfigTestService;
    }

}
