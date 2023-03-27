package com.example.rabbitmq;

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
