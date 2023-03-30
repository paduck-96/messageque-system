package com.example.rabbitmq.rabbitWebPush;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class WebPushSender {
    public Flux<ServerSentEvent<String>> sendWebPush(RabbitWebPushMessage message) {
        System.out.println(message.getMessage());
        String notification = message.getMessage();
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(sequence))
                        .event("web-push")
                        .data(notification)
                        .build())
                .onBackpressureDrop();
    }
}
