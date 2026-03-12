package com.digitalLoan.model;

public class CarLoan extends Loan implements LoanEligibility {

    public CarLoan(String loanId, String borrowerName,
                   double principal, double interestRate)
            throws InvalidLoanException {

        super(loanId, borrowerName, principal, interestRate);
        System.out.println("CarLoan Constructor Called");
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate * 2 / 100);
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= 30000;
    }
}