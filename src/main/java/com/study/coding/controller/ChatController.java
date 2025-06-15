package com.study.coding.controller;

import com.study.coding.config.RedisPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {
    private final RedisPublisher redisPublisher;

    public ChatController(RedisPublisher redisPublisher) {
        this.redisPublisher = redisPublisher;
    }

    @MessageMapping("/chat/send")
    public void sendMessage(String message) {
        log.info("controller 왔다!! {}", message);
        redisPublisher.publish(message);
    }
}
