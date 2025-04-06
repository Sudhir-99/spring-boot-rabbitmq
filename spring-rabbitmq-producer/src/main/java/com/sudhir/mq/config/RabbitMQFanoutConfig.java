package com.sudhir.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    public static final String MARKETING_QUEUE = "marketingQueue";
    public static final String FINANCE_QUEUE = "financeQueue";
    public static final String ADMIN_QUEUE = "adminQueue";
    public static final String FANOUT_EXCHANGE = "fanout-exchange";

    @Bean
    public Queue marketingFanoutQueue(){
        return new Queue(MARKETING_QUEUE,false);
    }
    @Bean
    public Queue financeFanoutQueue(){
        return new Queue(FINANCE_QUEUE,false);
    }
    @Bean
    public Queue adminFanoutQueue(){
        return new Queue(ADMIN_QUEUE,false);
    }


    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    Binding marketingFanoutBinding(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }

    @Bean
    Binding financeFanoutBinding(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }

    @Bean
    Binding adminFanoutBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }
}
