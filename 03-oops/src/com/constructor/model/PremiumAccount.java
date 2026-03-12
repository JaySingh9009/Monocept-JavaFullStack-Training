package com.constructor.model;

public class PremiumAccount extends BankAccount {

    private double bonus;

    public PremiumAccount(String accountNumber, String accountHolderName, double balance, double bonus) {
        super(accountNumber, accountHolderName, balance);

        if (bonus < 0) {
            System.out.println("Invalid bonus. Bonus cannot be negative. Setting bonus to 0.");
            this.bonus = 0;
            return;
        }

        this.bonus = bonus;
        this.balance += bonus;   
    }
}

