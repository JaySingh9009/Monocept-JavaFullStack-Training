package com.InstituteSystem.model;

public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int studentId, String name, String course, double scholarshipAmount) {

        super(studentId, name, course); 

        if (scholarshipAmount < 0) {
            throw new IllegalArgumentException("Invalid scholarship amount");
        }

        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public void displayProfile() {

        super.displayProfile();

        System.out.println("Type: Scholarship Student");
        System.out.println("Scholarship Amount: " + scholarshipAmount);
        System.out.println("---------------------------");
    }
}