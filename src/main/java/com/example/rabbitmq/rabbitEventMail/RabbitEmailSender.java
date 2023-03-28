package com.example.rabbitmq.rabbitEventMail;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


// 실질적으로 메시지를 발송하는 코드
@Component
@AllArgsConstructor
public class RabbitEmailSender {
    private JavaMailSender javaMailSender;

    public void sendEmail(RabbitEmailMessage message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(message.getTo());
        mailMessage.setSubject(message.getSubject());
        mailMessage.setText(message.getText());
        javaMailSender.send(mailMessage);
    }
}
