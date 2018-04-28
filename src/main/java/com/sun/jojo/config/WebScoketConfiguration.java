package com.sun.jojo.config;

import com.sun.jojo.tools.Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * description:
 * EnableWebSocketMessageBroker注解开启使用STOMP协议来传输消息，
 * 并且实现了registerStompEndpoints方法添加了对应的STOMP使用SockJS协议。
 * 接下来我们配置两个实体用于浏览器与服务器端的通信交互。
 * @author sunjiamin
 * @date 2018-04-27 15:48
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebScoketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     *
     * 配置了一个简单的消息代理，如果不重载，默认情况下回自动配置一个简单的内存消息代理，用来处理以"/topic"为前缀的消息。
     * 这里重载configureMessageBroker()方法，
     * 消息代理将会处理前缀为"/topic"和"/queue"的消息。
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        /**
         *  这句话表示在topic和user域上可以向客户端发消息 服务端发送消息给客户端的域,多个用逗号隔开
         */
        registry.enableSimpleBroker(Constant.WEBSOCKETBROADCASTPATH, Constant.P2PPUSHBASEPATH);
        /**
         * 定义一对一推送的时候前缀 这句话表示给指定用户发送一对一的主题前缀是"/user"
         */
        registry.setUserDestinationPrefix(Constant.P2PPUSHBASEPATH);

        /**
         * 定义websoket前缀 这句话表示客户单向服务器端发送时的主题上面需要加"/app"作为前缀。
         */
        registry.setApplicationDestinationPrefixes(Constant.WEBSOCKETPATHPERFIX);
    }

    /**
     *  将"/endpointWisely"路径注册为STOMP端点，这个路径与发送和接收消息的目的路径有所不同，这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点，
     * 即用户发送请求url="/applicationName/endpointWisely"与STOMP server进行连接。之后再转发到订阅url；
     * PS：端点的作用——客户端在订阅或发布消息到目的地址前，要连接该端点。
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。
         * 在网页上可以通过"/endpointWisely"来和服务器的WebSocket连接
         * 比如：var socket = new SockJS("/endpointWisely");
         */
        registry.addEndpoint(Constant.WEBSOCKETPATH).withSockJS();
    }
}
