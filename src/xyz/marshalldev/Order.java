package xyz.marshalldev;

import xyz.marshalldev.Item.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class Order {

    private int orderNumber;
    private Cart cart;
    private Date date;

    public Order(Cart cart, int orderNumber) {
        this.cart = cart;
        this.orderNumber = orderNumber;

        date = new Date();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //The system stores the customer order, containing the order date, customer ID, product name,
    //quantity, total, and authorization number.
    //9. The system displays order confirmation to the customer.

}
