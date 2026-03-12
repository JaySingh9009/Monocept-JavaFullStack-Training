package com.Inheritance.model;

public class Account {

    protected int accountNumber;     
    protected String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance) {

        if (accountNumber <= 0) {
            System.out.println("Account number must be positive. Account not created.");
            return;
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;

        if (balance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
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
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
 
    }
}
