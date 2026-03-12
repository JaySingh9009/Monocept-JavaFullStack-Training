package com.abstraction.mode;

public class UPIPayment extends Payment {

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        if (!validateAmount()) {
            return;
        }

        System.out.println("Processing UPI Payment...");
        System.out.println("No processing fee applied.");
        System.out.println("Total Amount Charged: " + amount);
    }
}
