# Kafka Book Order System

## Overview

This project demonstrates a simple event-driven application using Apache Kafka. A Java producer sends book order messages to a Kafka topic, and a Java consumer receives and processes those messages.

## Technologies Used

* Java 21
* Apache Kafka
* Maven
* Git & GitHub
* IntelliJ IDEA

## Project Structure

```
src
└── main
    └── java
        └── com
            └── merry
                └── kafka
                    ├── config
                    │   └── KafkaConfig.java
                    ├── consumer
                    │   └── BookOrderConsumer.java
                    ├── model
                    │   └── BookOrder.java
                    ├── producer
                    │   └── BookOrderProducer.java
                    └── Main.java
```

## How to Run the Project

### 1. Start ZooKeeper

```bash
cd ~/bigdata/kafka
./bin/zookeeper-server-start.sh ./config/zookeeper.properties
```

### 2. Start the Kafka Broker

Open a new terminal and run:

```bash
cd ~/bigdata/kafka
./bin/kafka-server-start.sh ./config/server.properties
```

### 3. Create the Kafka Topic

```bash
cd ~/bigdata/kafka

./bin/kafka-topics.sh \
--create \
--topic book-orders \
--bootstrap-server localhost:9092 \
--partitions 1 \
--replication-factor 1
```

If the topic already exists, Kafka will display a message indicating that.

### 4. Run the Consumer

Run the `BookOrderConsumer` class from IntelliJ.

The consumer will wait for incoming messages.

### 5. Run the Producer

Run the `Main` class from IntelliJ.

The producer will publish book order messages to the `book-orders` topic.

### 6. Expected Output

Consumer output:

```text
Received Order:
{"orderId":1,"customerName":"Merhawit","bookName":"Kafka Fundamentals","quantity":1,"price":35.99}
```

## Project Workflow

```
BookOrderProducer
        |
        v
Kafka Topic (book-orders)
        |
        v
BookOrderConsumer
```

The producer publishes messages to Kafka, and the consumer subscribes to the topic and processes each message independently.
