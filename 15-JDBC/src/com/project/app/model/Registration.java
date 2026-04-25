package com.project.app.model;

public class Registration {
    private int regId;
    private int studentId;
    private int courseId;
    private String courseName; // For display purposes
    private double feesPaid;

    public Registration() {}

    public Registration(int regId, int studentId, int courseId, double feesPaid) {
        this.regId = regId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.feesPaid = feesPaid;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId=" + regId +
                ", studentId=" + studentId +
                ", course='" + (courseName != null ? courseName : courseId) + '\'' +
                ", feesPaid=" + feesPaid +
                '}';
    }
}
