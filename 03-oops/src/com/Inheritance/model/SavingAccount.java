package com.Inheritance.model;

public class SavingAccount extends Account {

    private double minBalance = 1000;

    public SavingAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

 
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (balance - amount < minBalance) {
            System.out.println("Withdrawal denied! Minimum balance of " + minBalance + " must be maintained.");
            return;
        }

        super.withdraw(amount);  
    }


	
}
