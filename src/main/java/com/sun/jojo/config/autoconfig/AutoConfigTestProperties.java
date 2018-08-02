package com.sun.jojo.config.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * description: 自动配置的属性
 *
 * @author sunjiamin
 * @date 2018-07-25 10:08
 */
@ConfigurationProperties(prefix = "autoconfigtest")
public class AutoConfigTestProperties {

    //现在我们在配置文件写autoconfigtest.msg=world,因为简单就不再展示;如果那么默认为default.
    private String msg="default";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
