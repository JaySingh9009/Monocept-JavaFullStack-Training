package com.project.app.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private int branchId;
    private String branchName; 

    public Student() {}

    public Student(int id, String name, int age, int branchId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.branchId = branchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", branch='" + (branchName != null ? branchName : branchId) + '\'' +
                '}';
    }
}
