package com.digitalLoan.model;

public class EducationLoan extends Loan implements LoanEligibility {

    public EducationLoan(String loanId, String borrowerName,
                         double principal, double interestRate)
            throws InvalidLoanException {

        super(loanId, borrowerName, principal, interestRate);
        System.out.println("EducationLoan Constructor Called");
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate / 200);
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= 20000;
    }
}