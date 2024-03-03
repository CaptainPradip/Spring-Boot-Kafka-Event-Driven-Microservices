package com.kafka.microservice.ordermicroservice.controllers;

import com.kafka.microservice.basedomains.dto.Order;
import com.kafka.microservice.ordermicroservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }


}
