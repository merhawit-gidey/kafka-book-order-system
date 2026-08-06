package com.merry.kafka.controller;


import com.merry.kafka.model.BookOrder;
import com.merry.kafka.producer.BookOrderProducer;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {


    private final BookOrderProducer producer;


    public OrderController(BookOrderProducer producer){

        this.producer = producer;

    }



    @PostMapping
    public String createOrder(
            @RequestBody BookOrder order
    ){

        producer.sendOrder(order);

        return "Order sent successfully";

    }

}