package com.Interfaces.model;

public class TheoryExam implements ExamEvaluator {

    private double marks;

    @Override
    public void evaluateMarks(double marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks for Theory Exam. Must be between 0 and 100.");
            this.marks = -1;
        } else {
            this.marks = marks;
        }
    }

    @Override
    public void calculateGrade() {
        if (marks < 0) return;

        if (marks >= 85) {
            System.out.println("Theory Exam Grade: A");
        } else if (marks >= 60) {
            System.out.println("Theory Exam Grade: B");
        } else if (marks >= 40) {
            System.out.println("Theory Exam Grade: C");
        } else {
            System.out.println("Theory Exam Result: Fail");
        }
    }
}