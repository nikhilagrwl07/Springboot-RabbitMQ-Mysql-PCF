package com.example.cftest.cftest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendFirstMessage() {
        this.rabbitTemplate.convertAndSend("directExchange", "first", "Welcome");
    }

    public void sendSecondMessage() {
        this.rabbitTemplate.convertAndSend("directExchange", "second", "Welcome Again");
    }
}
