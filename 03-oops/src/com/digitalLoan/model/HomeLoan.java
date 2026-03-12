package com.digitalLoan.model;

public class HomeLoan extends Loan implements LoanEligibility {

    public HomeLoan(String loanId, String borrowerName,
                    double principal, double interestRate)
            throws InvalidLoanException {

        super(loanId, borrowerName, principal, interestRate);
        System.out.println("HomeLoan Constructor Called");
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate / 100);
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= 50000;
    }
}