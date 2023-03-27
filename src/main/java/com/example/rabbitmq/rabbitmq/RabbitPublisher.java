package com.example.rabbitmq.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitPublisher {
    private final AmqpTemplate amqpTemplate;

    public void publish(Subscription subscription) {
        amqpTemplate.convertAndSend("subscription-exchange", subscription.getTopic(), subscription.getEmail());
    }
}
