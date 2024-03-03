package com.kafka.microservice.ordermicroservice.services;

import com.kafka.microservice.basedomains.dto.Order;
import com.kafka.microservice.basedomains.events.OrderEvent;
import com.kafka.microservice.ordermicroservice.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired(required = true)
    private KafkaProducer kafkaProducer;

    public Order createOrder(Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent("Order status is Pending", "PENDING", order);
        kafkaProducer.sendMessage(orderEvent);
        return order;
    }

}


