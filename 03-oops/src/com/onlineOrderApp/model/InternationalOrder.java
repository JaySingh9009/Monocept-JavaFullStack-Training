package com.onlineOrderApp.model;

public class InternationalOrder extends Order implements OrderVerification {

    public InternationalOrder(int orderId, String customerName, double orderAmount)
            throws InvalidOrderException {

        super(orderId, customerName, orderAmount);
        System.out.println("InternationalOrder Constructor Called");
    }

    public double processOrder() {

        return orderAmount + (orderAmount * 0.2);
    }

    public boolean verifyOrder() {

        return orderAmount >= 2000;
    }
}