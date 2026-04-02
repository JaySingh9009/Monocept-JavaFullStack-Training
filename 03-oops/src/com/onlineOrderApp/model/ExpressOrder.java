package com.onlineOrderApp.model;

public class ExpressOrder extends Order implements OrderVerification {

    public ExpressOrder(int orderId, String customerName, double orderAmount)
            throws InvalidOrderException {

        super(orderId, customerName, orderAmount);
        System.out.println("ExpressOrder Constructor Called");
    }

    public double processOrder() {

        return orderAmount + 150;
    }

    public boolean verifyOrder() {

        return orderAmount >= 1000;
    }
}
