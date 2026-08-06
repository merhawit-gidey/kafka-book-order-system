# Kafka Book Order System

A Spring Boot application that demonstrates **event-driven communication** using **Apache Kafka**. The application exposes a REST API to receive book orders, stores them in PostgreSQL, and publishes the order as a Kafka message for asynchronous processing.

---

## Features

- REST API for creating book orders
- Apache Kafka Producer
- Apache Kafka Consumer
- PostgreSQL database integration using Spring Data JPA
- JSON serialization with Jackson
- Docker Compose for Kafka and ZooKeeper
- Layered architecture (Controller → Service → Repository)

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Apache Kafka
- PostgreSQL
- Jackson
- Maven
- Docker & Docker Compose

---

## Project Structure

```
kafka-book-order-system
│
├── docker-compose.yml
├── pom.xml
├── README.md
│
└── src
    └── main
        ├── java
        │   └── com.merry.kafka
        │       ├── controller
        │       ├── service
        │       ├── repository
        │       ├── producer
        │       ├── consumer
        │       ├── model
        │       └── KafkaBookOrderApplication.java
        │
        └── resources
            └── application.properties
```

---

# System Architecture

```
                Client
                   │
                   │ POST /orders
                   ▼
          OrderController
                   │
                   ▼
             OrderService
             /          \
            /            \
           ▼              ▼
 PostgreSQL Database   Kafka Producer
      (JPA)                  │
                              ▼
                    Kafka Topic (book-orders)
                              │
                              ▼
                     Kafka Consumer
```

---

## ⚙️ Prerequisites

Install:

- Java 21
- Maven
- Docker
- Docker Compose
- PostgreSQL

---

## Start Kafka & ZooKeeper

From the project directory:

```bash
docker compose up -d
```

Verify containers:

```bash
docker ps
```

---

## PostgreSQL Setup

Create the database:

```sql
CREATE DATABASE book_orders;
```

---

## Application Configuration

`application.properties`

```properties
spring.kafka.bootstrap-servers=localhost:9092

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/book_orders
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Replace `YOUR_PASSWORD` with your PostgreSQL password.

---

## Run the Application

```bash
mvn spring-boot:run
```

---

## REST API

### Create Order

**POST**

```
http://localhost:8080/orders
```

### Request Body

```json
{
  "orderId": 1,
  "customerName": "Merhawit",
  "bookName": "Kafka Fundamentals",
  "quantity": 1,
  "price": 35.99
}
```

### Response

```
Order saved and sent to Kafka
```

---

## Verify Database

Open PostgreSQL:

```sql
SELECT * FROM book_orders;
```

Example:

| order_id | customer_name | book_name | quantity | price |
|----------:|---------------|-----------|----------|------:|
| 1 | Merhawit | Kafka Fundamentals | 1 | 35.99 |

---

## Kafka Consumer Output

```
Received Order:

{
  "orderId": 1,
  "customerName": "Merhawit",
  "bookName": "Kafka Fundamentals",
  "quantity": 1,
  "price": 35.99
}
```

---

## Test with cURL

```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{
  "orderId":2,
  "customerName":"Merhawit",
  "bookName":"Spring Boot in Action",
  "quantity":1,
  "price":45.99
}'
```

---

## Workflow

1. Client sends a POST request.
2. Spring Boot receives the request.
3. The order is saved to PostgreSQL.
4. The order is published to Kafka.
5. Kafka Consumer receives the message.
6. Consumer processes the event.

---

## Future Improvements

- Dockerize the Spring Boot application
- Kafka Streams integration
- Authentication with Spring Security
- Unit and Integration Tests
- Swagger/OpenAPI documentation
- Kafka monitoring with Kafka UI
- CI/CD using GitHub Actions
