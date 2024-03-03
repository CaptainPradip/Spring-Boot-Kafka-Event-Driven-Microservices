package com.kafka.microservice.stockmicroservice.kafka_consumer;

import com.kafka.microservice.basedomains.events.OrderEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderConsumer {
    private  static final Logger LOGGER = Logger.getLogger(OrderConsumer.class.getName());


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("#### -> Consumed message -> %s", orderEvent));
        // call the stock service to update the stock


    }
}
