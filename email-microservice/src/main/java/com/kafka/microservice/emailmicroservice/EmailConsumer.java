package com.kafka.microservice.emailmicroservice;

import com.kafka.microservice.basedomains.events.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EmailConsumer {
    private  static final Logger LOGGER = Logger.getLogger(EmailConsumer.class.getName());


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("#### -> Consumed message Email Service -> %s", orderEvent));
            // call the email service to send email
    }
}
