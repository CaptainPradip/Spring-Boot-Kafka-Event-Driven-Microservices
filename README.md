# Spring-Boot-Kafka-Event-Driven-Microservices

This project demonstrates an event-driven microservices architecture using Spring Boot and Apache Kafka with multiple consumers.

## Overview

The application consists of three main microservices:

- **Microservice 1: Order Service** - This service is responsible for handling order events. It produces `OrderEvent` messages to a Kafka topic.
- **Microservice 2: Stock Service** - This service consumes `OrderEvent` messages to update stock levels and is part of `Consumer Group 1`.
- **Microservice 3: Email Service** - This service also consumes `OrderEvent` messages to send email notifications and is part of `Consumer Group 2`.

## Architecture Diagram

The following diagram illustrates the flow of messages through the system:

![Architecture Diagram](/architecture.png)

## Prerequisites

To run this project, you will need:
- JDK 1.8 or later
- Maven 3.2+
- Apache Kafka

## Running the Application

1. Start the Kafka broker.
2. Run each microservice in the order listed above.
3. To produce messages to the Kafka topic, use the REST endpoint provided by the Order Service.
4. Verify that the Stock Service and Email Service consume the messages appropriately.

## Configuration

Each microservice can be configured via its `application.properties` file. Here you can set Kafka properties such as the topic name, group ID, and bootstrap servers.
