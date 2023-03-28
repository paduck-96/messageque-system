package com.example.rabbitmq.rabbitEventMail;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class RabbitEmailController {
    private final RabbitSender rabbitSender;


    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody RabbitEmailRequestDTO dto){
        rabbitSender.sendEmailInfo(RabbitDTOtoEmail.DTOtoEmail(dto));
        return ResponseEntity.ok("메일 발송 완료!");

    }
}
