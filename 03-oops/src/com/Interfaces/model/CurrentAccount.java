package com.Interfaces.model;

public class CurrentAccount implements AccountOperations {

    private double balance;

    public CurrentAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited to Current: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        // Current account can go negative (overdraft)
        balance -= amount;
        System.out.println("Withdrawn from Current: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + balance);
    }
}