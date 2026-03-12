package com.Exceptionhandling.model;

public class StudentGrading{

    public void processStudent(String name, int marks) 
            throws InvalidMarksException {

        if (name == null) {
            throw new NullPointerException("Student name cannot be null.");
        }

        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException(
                "Marks must be between 0 and 100."
            );
        }

        String grade;

        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 75) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }

        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}