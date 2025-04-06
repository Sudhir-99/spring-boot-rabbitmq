package com.sudhir.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String REPLY_QUEUE = "message_reply_queue";
    public static final String EXCHANGE = "message_reply_exchange";
    public static final String ROUTING_KEY = "message_reply_routingKey";

    public static final String QUEUE = "order_queue";
    public static final String MARKETING_QUEUE = "marketingQueue";
    public static final String FINANCE_QUEUE = "financeQueue";
    public static final String ADMIN_QUEUE = "adminQueue";

    @Bean
    public Queue queue() {
        return  new Queue(REPLY_QUEUE);
    }

    @Bean
    public TopicExchange topicReplyExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}