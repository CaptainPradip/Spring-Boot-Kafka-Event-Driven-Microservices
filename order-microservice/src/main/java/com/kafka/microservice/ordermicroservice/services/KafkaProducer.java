package com.kafka.microservice.ordermicroservice.services;

import com.kafka.microservice.basedomains.events.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = Logger.getLogger(KafkaProducer.class.getName());

    @Autowired
    private NewTopic topic;
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("#### -> Producing message -> %s", orderEvent));
        Message<OrderEvent> message = MessageBuilder.withPayload(orderEvent).setHeader(
                KafkaHeaders.TOPIC, topic.name()).build(
        );

        kafkaTemplate.send(message);
    }

}
