package com.digitalLoan.model;

public abstract class Loan {

    public String loanId;
    public String borrowerName;
    protected double principal;
    protected double interestRate;

    static {
        System.out.println("Loan Processing System Initialized...");
    }

    public Loan(String loanId, String borrowerName, double principal, double interestRate)
            throws InvalidLoanException {

        System.out.println("Loan Constructor Called");

        if (principal <= 0) {
            throw new InvalidLoanException("Principal amount must be greater than 0.");
        }

        if (interestRate <= 0 || interestRate > 100) {
            throw new InvalidLoanException(
                    "Interest rate must be greater than 0 and less than or equal to 100.");
        }

        this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.interestRate = interestRate;
    }

    public abstract double calculateRepayment();
}