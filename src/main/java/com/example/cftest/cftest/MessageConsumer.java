package com.example.cftest.cftest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "First_Queue")
    public void consumeFirstQueueMessage(String message) {
        System.out.println("First Queue Message *****************" + message);
    }

    @RabbitListener(queues = "Second_Queue")
    public void consumeSecondQueueMessage(String message) {
        System.out.println("Second Queue Message *****************" + message);
    }
}
