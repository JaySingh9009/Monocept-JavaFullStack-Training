package com.Arrayofobject.model;
public class Intern extends Employee {

    private double stipend;

    public Intern(int empId, String name, double stipend) {
        super(empId, name, 0); 
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend;
    }
}
