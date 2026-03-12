package com.Interfaces.model;

public class CreditCardPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of " + amount);
        System.out.println("Credit Card payment successful.");
    }
}
