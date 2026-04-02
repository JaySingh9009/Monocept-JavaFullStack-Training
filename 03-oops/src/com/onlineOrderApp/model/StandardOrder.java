package com.onlineOrderApp.model;

public class StandardOrder extends Order implements OrderVerification {

    public StandardOrder(int orderId, String customerName, double orderAmount)
            throws InvalidOrderException {

        super(orderId, customerName, orderAmount);
        System.out.println("StandardOrder Constructor Called");
    }

    public double processOrder() {

        return orderAmount + 50;
    }

    public boolean verifyOrder() {

        return orderAmount >= 500;
    }
}
