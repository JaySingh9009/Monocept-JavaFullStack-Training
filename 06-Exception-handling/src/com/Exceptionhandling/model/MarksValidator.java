package com.Exceptionhandling.model;

public class MarksValidator {

    public void validateMarks(int marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }

        System.out.println("Valid marks");
    }
}