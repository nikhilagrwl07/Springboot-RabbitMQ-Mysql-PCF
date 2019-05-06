package com.example.cftest.cftest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.firstroutingkey}")
    private String firstroutingkey;

    @Value("${rabbitmq.secondroutingkey}")
    private String secondroutingkey;


    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendFirstMessage(EmployeeMessage emp) {
        this.rabbitTemplate.convertAndSend(exchange, firstroutingkey, emp);
        System.out.println("Messange produced in first queue");
    }

    public void sendSecondMessage(EmployeeMessage emp) {
        this.rabbitTemplate.convertAndSend(exchange, secondroutingkey, emp);
        System.out.println("Messange produced in first queue");
    }
}
