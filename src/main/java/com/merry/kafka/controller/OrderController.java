package com.merry.kafka.controller;


import com.merry.kafka.model.BookOrder;
import com.merry.kafka.service.OrderService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;


    public OrderController(OrderService orderService){

        this.orderService = orderService;

    }



    @PostMapping
    public String createOrder(
            @RequestBody BookOrder order
    ){

        orderService.createOrder(order);

        return "Order saved and sent to Kafka";

    }

}