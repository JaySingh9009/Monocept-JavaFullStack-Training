package com.streamApi.EmployeeAssignment.model;

public class DuplicateIdException extends Exception {
    public DuplicateIdException(String msg) {
        super(msg);
    }
}
