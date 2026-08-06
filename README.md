# Kafka Book Order System

## Overview

This project demonstrates a simple event-driven application using Apache Kafka.

## Technologies

- Java 21
- Apache Kafka
- Maven
- Git

## Project Structure

```
src
 └── main
     └── java
         └── com.merry.kafka
             ├── producer
             ├── consumer
             ├── model
             ├── config
             └── Main.java
```

## Workflow

Producer → Kafka Topic → Consumer

## How to Run

1. Start ZooKeeper
2. Start Kafka Broker
3. Create the topic `book-orders`
4. Run `BookOrderConsumer`
5. Run `Main`

## Sample Output

```
Received Order:
{"orderId":1,"customerName":"Merhawit","bookName":"Kafka Fundamentals","quantity":1,"price":35.99}
```