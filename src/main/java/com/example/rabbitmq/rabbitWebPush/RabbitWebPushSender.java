package com.example.rabbitmq.rabbitWebPush;

import com.example.rabbitmq.config.RabbitConfig;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Log4j2
public class RabbitWebPushSender {
    private final WebPushSender webPushSender;

    @RabbitListener(queues = RabbitConfig.RABBIT_PUSH_QUEUE)
    public String sendWebPush(RabbitWebPushMessage message) {
//        webPushSender.sendWebPush(message);
        String notification = message.getMessage();
        /*
        Flux.interval(Duration.ofSeconds(30))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(sequence))
                        .event("web-push")
                        .data(notification)
                        .build())
                .onBackpressureDrop();
        */

        //return Flux.<String>generate(sink -> sink.next(notification)).delayElements(Duration.ofSeconds(30));
        return notification;
    }
}
