package com.merry.kafka.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "book_orders")
public class BookOrder {


    @Id
    private int orderId;

    private String customerName;

    private String bookName;

    private int quantity;

    private double price;


    // Required by JPA
    public BookOrder() {
    }


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


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPrice(double price) {
        this.price = price;
    }


}