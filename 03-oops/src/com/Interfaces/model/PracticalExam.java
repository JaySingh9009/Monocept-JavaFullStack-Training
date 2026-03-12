package com.Interfaces.model;

public class PracticalExam implements ExamEvaluator {

    private double marks;

    @Override
    public void evaluateMarks(double marks) {
        if (marks < 0 || marks > 50) {
            System.out.println("Invalid marks for Practical Exam. Must be between 0 and 50.");
            this.marks = -1;
        } else {
            this.marks = marks;
        }
    }

    @Override
    public void calculateGrade() {
        if (marks < 0) return;

        if (marks >= 40) {
            System.out.println("Practical Exam Grade: Excellent");
        } else if (marks >= 30) {
            System.out.println("Practical Exam Grade: Good");
        } else if (marks >= 20) {
            System.out.println("Practical Exam Grade: Average");
        } else {
            System.out.println("Practical Exam Result: Fail");
        }
    }
}