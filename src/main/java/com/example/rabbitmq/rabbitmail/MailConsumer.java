package com.example.rabbitmq.rabbitmail;

import com.example.rabbitmq.config.RabbitConfig;
import com.example.rabbitmq.dto.RequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailConsumer {
    private final JavaMailSender mailSender;

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void sendEmail(RequestDTO dto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getText());

        mailSender.send(message);
    }
}
