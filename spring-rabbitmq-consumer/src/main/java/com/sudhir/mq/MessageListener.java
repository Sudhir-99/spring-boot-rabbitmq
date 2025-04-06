package com.sudhir.mq;

import com.sudhir.mq.config.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.sudhir.mq.config.CustomMessage;
import com.sudhir.mq.config.MQConfig;

@Component
@Slf4j
public class MessageListener {
	
   /* @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        log.info("Order Received : {} ",message);
    }*/

    // Topic Exchange Listener
    @RabbitListener(queues = MQConfig.QUEUE)
    public void topicListener(MyMessage message) {
        log.info("Message Received : {} ",message.getMessage());
    }

    // Direct & Fanout Exchange Listener
    @RabbitListener(queues = MQConfig.ADMIN_QUEUE)
    public void directAdminListener(String message) {
        log.info("Message Received By ADMIN_QUEUE Listener : {} ",message);
    }

    @RabbitListener(queues = MQConfig.MARKETING_QUEUE)
    public void directMarketingListener(String message) {
        log.info("Message Received By MARKETING_QUEUE Listener : {} ",message);
    }

    @RabbitListener(queues = MQConfig.FINANCE_QUEUE)
    public void directFinanceListener(String message) {
        log.info("Message Received By FINANCE_QUEUE Listener : {} ",message);
    }

} 