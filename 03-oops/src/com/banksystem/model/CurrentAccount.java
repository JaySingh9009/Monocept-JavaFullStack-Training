package com.banksystem.model;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber, String holderName,
                          double balance, double overdraftLimit) {

        super(accountNumber, holderName, balance);

        if(overdraftLimit < 0)
            throw new IllegalArgumentException("Invalid overdraft limit");

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Account Type    : Current Account");
        System.out.println("Overdraft Limit : " + overdraftLimit);
        System.out.println("----------------------------------");
    }
}
