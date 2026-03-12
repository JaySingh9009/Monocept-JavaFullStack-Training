package com.banksystem.model;

public class Account {

    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {

        if(accountNumber <= 0)
            throw new IllegalArgumentException("Invalid account number");

        if(holderName == null || holderName.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        if(balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void displayDetails() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holderName);
        System.out.println("Balance        : " + balance);
    }
}