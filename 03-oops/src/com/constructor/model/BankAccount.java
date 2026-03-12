package com.constructor.model;

public class BankAccount {

    private final String accountNumber;   
    private String accountHolderName;
    protected double balance;

    private static double interestRate;
    static {
        interestRate = 4.5;
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0);
    }
    public BankAccount(String accountNumber, String accountHolderName, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (balance < 0) {
            System.out.println("Invalid balance. Balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
            return;
        }

        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
    }
}
