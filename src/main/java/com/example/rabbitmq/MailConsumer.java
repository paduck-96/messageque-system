package com.example.rabbitmq;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
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
