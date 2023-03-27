package com.example.rabbitmq.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class RequestDTO {

    private String to;
    private String subject;
    private String text;
}
