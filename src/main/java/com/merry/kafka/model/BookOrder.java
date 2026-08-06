package com.merry.kafka.model;

public class BookOrder {

    private int orderId;
    private String customerName;
    private String bookName;
    private int quantity;
    private double price;


    public BookOrder(
            int orderId,
            String customerName,
            String bookName,
            int quantity,
            double price
    ) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
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


    public int getQuantity() {
        return quantity;
    }


    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {

        return "{"
                + "\"orderId\":" + orderId + ","
                + "\"customerName\":\"" + customerName + "\","
                + "\"bookName\":\"" + bookName + "\","
                + "\"quantity\":" + quantity + ","
                + "\"price\":" + price
                + "}";

    }
}