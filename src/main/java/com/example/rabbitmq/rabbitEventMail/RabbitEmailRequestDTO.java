package com.example.rabbitmq.rabbitEventMail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitEmailRequestDTO {
    private Long userId;
    private String userEmail;
    private String roomId;
    private LocalDateTime startTime;
    private String roomUrl;
}
