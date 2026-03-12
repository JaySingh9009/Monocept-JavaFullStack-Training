package com.Interfaces.model;

public class OnlineQuiz implements ExamEvaluator {

    private double marks;

    @Override
    public void evaluateMarks(double marks) {
        if (marks < 0 || marks > 20) {
            System.out.println("Invalid marks for Online Quiz. Must be between 0 and 20.");
            this.marks = -1;
        } else {
            this.marks = marks;
        }
    }

    @Override
    public void calculateGrade() {
        if (marks < 0) return;

        if (marks >= 18) {
            System.out.println("Online Quiz Grade: Outstanding");
        } else if (marks >= 14) {
            System.out.println("Online Quiz Grade: Very Good");
        } else if (marks >= 10) {
            System.out.println("Online Quiz Result: Pass");
        } else {
            System.out.println("Online Quiz Result: Fail");
        }
    }
}