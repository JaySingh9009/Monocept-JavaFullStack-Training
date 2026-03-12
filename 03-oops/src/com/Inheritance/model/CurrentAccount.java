package com.Inheritance.model;
public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount + " (Current Account with overdraft)");
    }
}

