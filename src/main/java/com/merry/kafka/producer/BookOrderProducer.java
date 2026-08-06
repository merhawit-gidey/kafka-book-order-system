package com.merry.kafka.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merry.kafka.model.BookOrder;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class BookOrderProducer {


    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;


    private static final String TOPIC = "book-orders";


    public BookOrderProducer(
            KafkaTemplate<String, String> kafkaTemplate
    ){

        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();

    }



    public void sendOrder(BookOrder order){


        try {

            String message =
                    objectMapper.writeValueAsString(order);


            kafkaTemplate.send(
                    TOPIC,
                    String.valueOf(order.getOrderId()),
                    message
            );


            System.out.println(
                    "Order sent: " + message
            );


        } catch (JsonProcessingException e){

            throw new RuntimeException(
                    "Error converting order to JSON",
                    e
            );

        }

    }

}