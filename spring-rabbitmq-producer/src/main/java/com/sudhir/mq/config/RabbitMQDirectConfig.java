package com.sudhir.mq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;

@Configuration
public class RabbitMQDirectConfig {

    public static final String MARKETING_QUEUE = "marketingQueue";
    public static final String FINANCE_QUEUE = "financeQueue";
    public static final String ADMIN_QUEUE = "adminQueue";
    public static final String ROUTING_KEY_MARKETING = "marketing";
    public static final String ROUTING_KEY_FINANCE = "finance";
    public static final String ROUTING_KEY_ADMIN = "admin";
    public static final String DIRECT_EXCHANGE = "direct-exchange";

    @Bean
    public Queue marketingQueue(){
        return new Queue(MARKETING_QUEUE,false);
    }
    @Bean
    public Queue financeQueue(){
        return new Queue(FINANCE_QUEUE,false);
    }
    @Bean
    public Queue adminQueue(){
        return new Queue(ADMIN_QUEUE,false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }


    @Bean
    Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange).with(ROUTING_KEY_MARKETING);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange).with(ROUTING_KEY_FINANCE);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange).with(ROUTING_KEY_ADMIN);
    }


}
