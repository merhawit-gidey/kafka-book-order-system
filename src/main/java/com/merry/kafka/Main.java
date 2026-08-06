package com.merry.kafka;


import com.merry.kafka.model.BookOrder;
import com.merry.kafka.producer.BookOrderProducer;



public class Main {


    public static void main(String[] args) {


        BookOrderProducer producer =
                new BookOrderProducer();



        BookOrder order =
                new BookOrder(
                        1,
                        "Merhawit",
                        "Kafka Fundamentals",
                        1,
                        35.99
                );


        producer.sendOrder(order);


    }

}