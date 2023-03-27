package com.example.rabbitmq.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RabbitController {
    private final RabbitPublisher rabbitPublisher;
    private final RabbitEmailPublisher rabbitEmailPublisher;

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestBody Subscription subscription) {
        rabbitPublisher.publish(subscription);
        return ResponseEntity.ok("Subscribed successfully");
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage) {
        rabbitEmailPublisher.publish(emailMessage);
        return ResponseEntity.ok("Email sent successfully");
    }

}
