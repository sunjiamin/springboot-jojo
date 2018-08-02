package com.sun.jojo.config.autoconfig;

/**
 * description: 需要自动配置服务类
 *
 * @author sunjiamin
 * @date 2018-07-25 10:11
 */
public class AutoConfigTestService {
    //如果自动配置没有读入成功，那么为默认值
    private String msg = "service";

    public String say() {
        return "hello " + msg;
    }//为我们服务的方法

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
