package com.study.coding.controller;

import com.study.coding.config.RedisPublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final RedisPublisher redisPublisher;

    public ChatController(RedisPublisher redisPublisher) {
        this.redisPublisher = redisPublisher;
    }

    @MessageMapping("/chat/send")
    public void sendMessage(String message) {
        redisPublisher.publish(message);
    }
}
