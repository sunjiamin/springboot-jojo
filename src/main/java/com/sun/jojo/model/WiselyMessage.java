package com.sun.jojo.model;

/**
 * description:
 * 创建一个简单的WiselyMessage实体，用于浏览器向服务端发送消息参数
 * @author sunjiamin
 * @date 2018-04-27 15:53
 */
public class WiselyMessage {
    private String name;
    /**
     * 发送方ID
     */
    private String currentUserId;
    /**
     * 接收方ID
     */
    private String sendToUserId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSendToUserId() {
        return sendToUserId;
    }

    public void setSendToUserId(String sendToUserId) {
        this.sendToUserId = sendToUserId;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
}
