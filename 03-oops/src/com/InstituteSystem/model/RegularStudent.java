package com.InstituteSystem.model;

public class RegularStudent extends Student {

    private double attendancePercentage;

    public RegularStudent(int studentId, String name, String course, double attendancePercentage) {

        super(studentId, name, course); // constructor chaining

        if (attendancePercentage < 0 || attendancePercentage > 100) {
            throw new IllegalArgumentException("Invalid attendance");
        }

        this.attendancePercentage = attendancePercentage;
    }

    @Override
    public void displayProfile() {

        super.displayProfile();

        System.out.println("Type: Regular Student");
        System.out.println("Attendance: " + attendancePercentage + "%");
        System.out.println("---------------------------");
    }
}
