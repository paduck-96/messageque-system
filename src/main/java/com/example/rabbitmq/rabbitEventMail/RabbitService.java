package com.example.rabbitmq.rabbitEventMail;

import com.example.rabbitmq.config.RabbitConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RabbitService {

    private final RabbitEmailSender rabbitEmailSender;

    // dto 변환
    @RabbitListener(queues = RabbitConfig.RABBIT_JOIN_QUEUE)
    public void rabbitSendEmail(RabbitEmailMessage message){
        rabbitEmailSender.sendEmail(message);
    }
}
