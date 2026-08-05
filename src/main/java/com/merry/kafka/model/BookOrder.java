package com.merry.kafka.model;

public class BookOrder {

    private int orderId;
    private String customerName;
    private String bookName;

    public BookOrder(int orderId, String customerName, String bookName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.bookName = bookName;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBookName() {
        return bookName;
    }
}