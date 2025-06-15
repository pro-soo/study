package com.study.coding.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisSubscriber {
    private final SimpMessagingTemplate messagingTemplate;

    public RedisSubscriber(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void onMessage(String message, String channel) {
//        String msg = new String(message.getBody());
        log.info("onMessage >> {}", message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
