package com.example.rabbitmq.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailMessage {
    private String from;
    private String to;
    private String subject;
    private String text;

}
