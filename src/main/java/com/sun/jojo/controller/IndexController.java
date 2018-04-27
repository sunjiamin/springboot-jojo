package com.sun.jojo.controller;

import com.sun.jojo.model.Msg;
import com.sun.jojo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 10:11
 */
@Controller
public class IndexController {
    /**
     * logback
     */
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/")
    public   String index(Model model){
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }

//    @RequestMapping(value = "/login")
//    public String login(){
//        return "home";
//    }
}
