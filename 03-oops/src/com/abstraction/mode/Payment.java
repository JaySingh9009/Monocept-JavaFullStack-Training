package com.abstraction.mode;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean validateAmount() {
        if (amount <= 0) {
            System.out.println("Invalid payment amount. Amount must be greater than 0.");
            return false;
        }
        return true;
    }

    public abstract void processPayment();

    public void generateReceipt() {
        System.out.println("Payment of " + amount + " processed successfully.");
        
    }
}
