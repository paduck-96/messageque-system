package com.example.rabbitmq.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitEmailPublisher {
    private final AmqpTemplate amqpTemplate;

    public void publish(EmailMessage emailMessage) {
        amqpTemplate.convertAndSend("direct-exchange", "email", emailMessage);
    }
}
