package com.sudhir.mq.controller;

import com.sudhir.mq.config.CustomMessage;
import com.sudhir.mq.config.MQConfig;
import com.sudhir.mq.config.MyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/message")
public class ReplyController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publish-reply")
    public String sendReply(@RequestBody MyMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY, message);

        return "Message sent Successfully";
    }
}
