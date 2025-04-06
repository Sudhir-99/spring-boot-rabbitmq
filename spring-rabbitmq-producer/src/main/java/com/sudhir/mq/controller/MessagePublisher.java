package com.sudhir.mq.controller;
import java.util.Date;
import java.util.UUID;

import com.sudhir.mq.config.RabbitMQDirectConfig;
import com.sudhir.mq.config.RabbitMQFanoutConfig;
import com.sudhir.mq.utils.MyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sudhir.mq.config.MQConfig;

@RestController
@RequestMapping("/message")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish-topic")
    public String topicPublishMessage(@RequestBody MyMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, message);

        return "Message sent Successfully";
    }

    @PostMapping(value = "/publish-direct")
    public String directPublishMessage(@RequestParam("routingKey") String routingKey,@RequestParam("message") String message) {
        template.convertAndSend(RabbitMQDirectConfig.DIRECT_EXCHANGE, routingKey, message);

        return "Message sent to the RabbitMQ Successfully";
    }

    @PostMapping(value = "/publish-fanout")
    public String fanoutPublishMessage(@RequestParam("message") String message) {
        template.convertAndSend(RabbitMQFanoutConfig.FANOUT_EXCHANGE,"", message);

        return "Message sent to the RabbitMQ Successfully";
    }
}