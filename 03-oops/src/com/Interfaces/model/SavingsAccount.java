package com.Interfaces.model;

public class SavingsAccount implements AccountOperations {

    private double balance;
    private static final double WITHDRAW_LIMIT = 10000;

    public SavingsAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited to Savings: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > WITHDRAW_LIMIT) {
            System.out.println("Savings withdrawal limit exceeded. Max allowed: ₹" + WITHDRAW_LIMIT);
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance in Savings Account.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn from Savings: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Savings Account Balance: ₹" + balance);
    }
}