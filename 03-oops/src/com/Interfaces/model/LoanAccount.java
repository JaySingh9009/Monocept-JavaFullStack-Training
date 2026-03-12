package com.Interfaces.model;

public class LoanAccount implements AccountOperations {

    private double loanAmount;

    public LoanAccount(double initialLoan) {
        if (initialLoan < 0) {
            System.out.println("Loan amount cannot be negative. Setting loan to 0.");
            this.loanAmount = 0;
        } else {
            this.loanAmount = initialLoan;
        }
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Deposits are not allowed in Loan Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }
        loanAmount += amount;  
        System.out.println("Loan taken: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Outstanding Loan Amount: ₹" + loanAmount);
    }
}