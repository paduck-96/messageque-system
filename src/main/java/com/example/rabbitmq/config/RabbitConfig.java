package com.example.rabbitmq.config;

import com.example.rabbitmq.rabbitmq.RabbitEmailWorker;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class RabbitConfig {
    public static final String QUEUE = "email";


    @Bean
    public Queue queue(){
        return new Queue(QUEUE, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(queue()).to(new TopicExchange("direct-exchange")).with("email");
    }

    @Bean
    public RabbitEmailWorker emailWorker(JavaMailSender javaMailSender) {
        return new RabbitEmailWorker(javaMailSender);
    }

    // RabbitMQ 로 이메일 발송
    public static final String RABBIT_JOIN_QUEUE = "rabbit-join-queue";
    public static final String RABBIT_JOIN_EXCHANGE = "rabbit-join-exchange";
    public static final String RABBIT_JOIN_ROUTING = "rabbit-join-routing";

    @Bean
    public Queue joinChatRoomEmailQueue() {
        return new Queue(RABBIT_JOIN_QUEUE);
    }
    @Bean
    public TopicExchange chatRoomExchange() {
        return new TopicExchange(RABBIT_JOIN_EXCHANGE);
    }

    @Bean
    public Binding joinChatRoomEmailBinding() {
        return BindingBuilder.bind(joinChatRoomEmailQueue()).to(chatRoomExchange()).with(RABBIT_JOIN_ROUTING);
    }

    // RabbitMQ 로 웹푸시 발송
    public static final String RABBIT_PUSH_QUEUE = "rabbit-push-queue";
    public static final String RABBIT_PUSH_EXCHANGE = "rabbit-push-exchange";
    public static final String RABBIT_PUSH_ROUTING = "rabbit-push-routing";
    @Bean
    public TopicExchange reservationExchange() {
        return new TopicExchange(RABBIT_PUSH_EXCHANGE);
    }

    @Bean
    public Queue reservationWebNotificationQueue() {
        return new Queue(RABBIT_PUSH_QUEUE);
    }

    @Bean
    public Binding reservationWebNotificationBinding() {
        return BindingBuilder.bind(reservationWebNotificationQueue())
                .to(reservationExchange())
                .with(RABBIT_PUSH_ROUTING);
    }
}
