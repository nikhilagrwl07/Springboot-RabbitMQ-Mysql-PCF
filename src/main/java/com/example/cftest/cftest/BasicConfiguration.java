package com.example.cftest.cftest;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration {

    @Bean
    public Queue firstQueue() {
        return new Queue("First_Queue");
    }

    @Bean
    public Queue secondQueue() {
        return new Queue("Second_Queue");
    }

    @Bean
    public DirectExchange sampleExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding firstBinding(Queue firstQueue, DirectExchange sampleExchange) {
        return BindingBuilder.bind(firstQueue).to(sampleExchange).with("first");
    }

    @Bean
    public Binding secondBinding(Queue secondQueue, DirectExchange sampleExchange) {
        return BindingBuilder.bind(secondQueue).to(sampleExchange).with("second");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
