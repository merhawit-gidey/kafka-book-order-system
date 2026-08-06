package com.merry.kafka.producer;


import org.apache.kafka.clients.producer.*;

import com.merry.kafka.model.BookOrder;

import java.util.Properties;


public class BookOrderProducer {


    private KafkaProducer<String,String> producer;


    public BookOrderProducer(){


        Properties properties = new Properties();


        properties.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );


        properties.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer"
        );


        properties.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer"
        );


        producer = new KafkaProducer<>(properties);

    }



    public void sendOrder(BookOrder order){


        ProducerRecord<String,String> record =
                new ProducerRecord<>(
                        "book-orders",
                        String.valueOf(order.getOrderId()),
                        order.toString()
                );


        producer.send(record);


        System.out.println(
                "Order sent: " + order
        );


        producer.close();

    }

}