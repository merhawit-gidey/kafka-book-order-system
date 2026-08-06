package com.merry.kafka.service;


import com.merry.kafka.model.BookOrder;
import com.merry.kafka.producer.BookOrderProducer;
import com.merry.kafka.repository.BookOrderRepository;

import org.springframework.stereotype.Service;


@Service
public class OrderService {


    private final BookOrderRepository repository;
    private final BookOrderProducer producer;


    public OrderService(
            BookOrderRepository repository,
            BookOrderProducer producer
    ){

        this.repository = repository;
        this.producer = producer;

    }



    public void createOrder(BookOrder order){

        repository.save(order);

        producer.sendOrder(order);

    }

}