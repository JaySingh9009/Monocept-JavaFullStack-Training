package com.onlineOrderApp.model;

public abstract class Order {

    public int orderId;
    public String customerName;
    public double orderAmount;

    static {
        System.out.println("Order System Configuration Loaded...");
    }

    public Order(int orderId, String customerName, double orderAmount)
            throws InvalidOrderException {

        System.out.println("Order Constructor Called");

        if (orderAmount <= 0)
            throw new InvalidOrderException("Order amount must be greater than 0");

        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public abstract double processOrder();
}
