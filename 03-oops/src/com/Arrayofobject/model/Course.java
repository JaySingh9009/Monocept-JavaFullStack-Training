package com.Arrayofobject.model;
public abstract class Course {

    private int courseId;
    private String courseName;
    protected double baseFee;
    private static int totalCourses = 0;

    public Course(int courseId, String courseName, double baseFee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.baseFee = baseFee;
        totalCourses++;
    }

    public abstract double calculateFee();



    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public static int getTotalCourses() {
        return totalCourses;
    }
}