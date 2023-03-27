package com.example.rabbitmq;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final MailProducer mailProducer;

    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody RequestDTO dto) throws MessagingException {

        mailService.sendMail(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody RequestDTO dto){
        mailProducer.sendEmail(dto);
        return ResponseEntity.ok("Email sent successfully!");
    }
}
