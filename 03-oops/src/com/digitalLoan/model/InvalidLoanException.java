package com.digitalLoan.model;

public class InvalidLoanException extends Exception {

    public InvalidLoanException(String message) {
        super(message);
    }
}