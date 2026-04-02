package com.streamApi.EmployeeAssignment.model;

public class InvalidInputException extends Exception {
    public InvalidInputException(String msg) {
        super(msg);
    }
}