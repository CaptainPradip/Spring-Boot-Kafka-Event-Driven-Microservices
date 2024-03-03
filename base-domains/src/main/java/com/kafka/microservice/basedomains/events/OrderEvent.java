package com.kafka.microservice.basedomains.events;

import com.kafka.microservice.basedomains.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private String message;
    private String status ;
    private Order order;
}
