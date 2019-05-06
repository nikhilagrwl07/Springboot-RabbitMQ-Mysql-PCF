package com.example.cftest.cftest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "First_Queue")
    public void consumeFirstQueueMessage(EmployeeMessage emp) {
        System.out.println("First Queue Message *****************" + emp.toString());
    }

    @RabbitListener(queues = "Second_Queue")
    public void consumeSecondQueueMessage(EmployeeMessage emp) {
        System.out.println("Second Queue Message *****************" + emp.toString());
    }
}
