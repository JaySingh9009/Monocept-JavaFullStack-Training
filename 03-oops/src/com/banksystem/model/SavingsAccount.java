package com.banksystem.model;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accountNumber, String holderName,
                          double balance, double interestRate) {

        super(accountNumber, holderName, balance); // constructor chaining

        if(interestRate < 0)
            throw new IllegalArgumentException("Invalid interest rate");

        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Account Type  : Savings Account");
        System.out.println("Interest Rate : " + interestRate + "%");
        System.out.println("----------------------------------");
    }
}