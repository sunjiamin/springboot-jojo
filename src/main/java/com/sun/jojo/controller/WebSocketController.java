package com.sun.jojo.controller;

import com.sun.jojo.model.WiselyMessage;
import com.sun.jojo.model.WiselyResponse;
import com.sun.jojo.service.WebSocketService;
import com.sun.jojo.tools.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.thymeleaf.expression.Lists;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-27 15:55
 */
@Controller
public class WebSocketController {

//    @Autowired
//    private SimpMessageSendingOperations simpMessageSendingOperations;
//
//    /**
//     * MessageMapping注解开启WebSocket的访问地址映射
//     * 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似@RequestMapping，
//     * 当服务端有消息存在时，会对订阅@SendTo中路径的浏览器发送请求。
//     * @param message
//     * @return
//     */
//    @MessageMapping("/welcome")
//    @SendTo("/topic/getResponse")
//    public WiselyResponse say(WiselyMessage message) throws Exception
//    {
//        //等待3秒返回消息内容
//        Thread.sleep(1000);
//        return new WiselyResponse("欢迎使用webScoket："+message.getName());
//    }
//
//
//    /**
//     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
//     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
//     * @return
//     */
//    @MessageMapping("/message")
//    @SendToUser("/message")
//    public WiselyResponse handleSubscribe() {
//        System.out.println("this is the @SubscribeMapping('/marco')");
//        return new WiselyResponse("欢迎使用webScoket：");
//    }
//
//    /**
//     * 测试对指定用户发送消息方法
//     * @return
//     */
//    @RequestMapping(path = "/send", method = RequestMethod.GET)
//    public WiselyResponse send() {
//        simpMessageSendingOperations.convertAndSendToUser("1", "/message", new WiselyResponse("I am a msg from SubscribeMapping('/macro')."));
//        return new WiselyResponse("I am a msg from SubscribeMapping('/macro').");
//    }



    @Resource
    WebSocketService webSocketService;

    @MessageMapping(Constant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo(Constant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WiselyResponse say(WiselyMessage message) throws Exception {
        List<String> users =  new ArrayList();
        //这里需要注意这里的userID是发送方的ID，需要通知所有订阅了当前用户的所有用户接收消息
        users.add(message.getCurrentUserId());
        webSocketService.send2Users(users, new WiselyResponse(message.getCurrentUserId()+" 发过来的消息： "+message.getName()));
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

}
