package com.example.rabbitmq.rabbitEventMail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitEmailMessage {
    private String to;
    private String subject;
    private String text;
}
