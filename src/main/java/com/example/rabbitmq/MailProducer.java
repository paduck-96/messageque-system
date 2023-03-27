package com.example.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendEmail(RequestDTO dto){
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE, dto);
    }
}
