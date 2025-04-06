package com.sudhir.mq.listener;

import com.sudhir.mq.config.MQConfig;
import com.sudhir.mq.utils.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @RabbitListener(queues = MQConfig.REPLY_QUEUE)
    public void topicListener(MyMessage message) {
        log.info("Message Received : {} ",message.getMessage());
    }
}
