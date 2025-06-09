package com.study.coding.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber {
    private final SimpMessagingTemplate messagingTemplate;

    public RedisSubscriber(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void onMessage(Message message, byte[] pattern) {
        String msg = new String(message.getBody());
        messagingTemplate.convertAndSend("/topic/messages", msg);
    }
}
