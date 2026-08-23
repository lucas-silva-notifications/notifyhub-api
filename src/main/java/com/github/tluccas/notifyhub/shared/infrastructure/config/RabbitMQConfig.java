package com.github.tluccas.notifyhub.shared.infrastructure.config;

import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    public static final String NOTIFICATION_EXCHANGE = "notification.events";
    public static final String EMAIL_NOTIFICATION_QUEUE = "email-notification.queue";
    public static final String EMAIL_NOTIFICATION_ROUTING_KEY = "notification.requested.email";

    @Bean()
    public TopicExchange notificationExchange() {
        return new TopicExchange(NOTIFICATION_EXCHANGE, true, false);
    }

    @Bean()
    public Queue emailNotificationQueue() {
        return QueueBuilder.durable(EMAIL_NOTIFICATION_QUEUE)
                .build();
    }

    @Bean()
    public Binding emailNotificationBinding() {
        return BindingBuilder.bind(emailNotificationQueue())
        .to(notificationExchange())
        .with(EMAIL_NOTIFICATION_ROUTING_KEY);
    }
    
}
