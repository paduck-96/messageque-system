package com.example.rabbitmq.rabbitEventMail;

import com.example.rabbitmq.config.RabbitConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
// 1. 컨트롤러에서 rabbitmq 로 전달하려는 메시지를 큐에 등록
public class RabbitSender {
    private RabbitTemplate rabbitTemplate;

    // exchange에 해 당 key 로 전달할 메시지 묶기
    public void sendEmailInfo(RabbitEmailMessage message) {
        rabbitTemplate.convertAndSend(RabbitConfig.RABBIT_JOIN_EXCHANGE, RabbitConfig.RABBIT_JOIN_ROUTING, message);
    }
}
