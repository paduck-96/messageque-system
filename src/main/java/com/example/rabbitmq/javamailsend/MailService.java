package com.example.rabbitmq.javamailsend;

import com.example.rabbitmq.dto.RequestDTO;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendMail(RequestDTO dto) throws MessagingException{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(dto.getTo());
        mailMessage.setSubject(dto.getSubject());
        mailMessage.setText(dto.getText());
        javaMailSender.send(mailMessage);
    }

}