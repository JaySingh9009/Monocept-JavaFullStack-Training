package com.Exceptionhandling.model;

public class ATMLogic {

    private double balance = 10000; 

    public double withdraw(double amount) {

        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance.");
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}
