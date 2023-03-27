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
}
