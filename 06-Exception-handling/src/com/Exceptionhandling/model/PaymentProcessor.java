package com.Exceptionhandling.model;

public class PaymentProcessor {

    public void processPayment() {

        try {
            
            String paymentDetails = null;
            System.out.println(paymentDetails.length());

        } catch (NullPointerException e) {

            throw new RuntimeException("Payment processing failed.", e);
        }
    }
}