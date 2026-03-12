package com.InstituteSystem.model;

public class Student {

    private int studentId;
    private String name;
    private String course;

    public Student(int studentId, String name, String course) {

        if (studentId <= 0 || name == null || name.isEmpty() || course == null || course.isEmpty()) {
            throw new IllegalArgumentException("Invalid student data");
        }

        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public void setCourse(String course) {

        if(course == null || course.trim().isEmpty())
            throw new IllegalArgumentException("Course cannot be empty");

        this.course = course;
    }

	public void displayProfile() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }

	public int getStudentId() {
		
		return studentId;
	}
}
