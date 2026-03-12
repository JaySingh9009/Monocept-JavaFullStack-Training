package com.encapsulation.model;

import java.util.Random;

public class BankAccount {
    private final int accountNumber;     
    private String accountHolderName;
    private double balance;
    private boolean validAccount;   

    public BankAccount(String accountHolderName, double initialBalance) {

        this.accountNumber = generateAccountNumber();

        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            System.out.println("Account holder name cannot be empty");
            validAccount = false;
            return;
        }
        if (Double.isNaN(initialBalance) || Double.isInfinite(initialBalance) || initialBalance < 0) {
            System.out.println("Initial balance must be a valid non-negative number");
            validAccount = false;
            return;
        }

        this.accountHolderName = accountHolderName.trim();
        this.balance = initialBalance;
        this.validAccount = true;
    }

    public boolean isValidAccount() {
        return validAccount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        if (!validAccount) {
            System.out.println("Invalid account. Balance unavailable.");
            return 0.0;
        }
        return balance;
    }

    public void deposit(double amount) {
        if (!validAccount) {
            System.out.println("Operation not allowed on invalid account");
            return;
        }
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            System.out.println("Deposit amount must be a valid positive number");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful");
    }

    public void withdraw(double amount) {
        if (!validAccount) {
            System.out.println("Operation not allowed on invalid account");
            return;
        }
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            System.out.println("Withdrawal amount must be a valid positive number");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful");
    }

    private int generateAccountNumber() {
        Random random = new Random();
        return 100_000_000 + random.nextInt(900_000_000); 
    }
}
