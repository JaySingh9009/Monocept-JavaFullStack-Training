package com.Arrayofobject.model;
public class FullTimeEmployee extends Employee {

    private double hra;
    private double da;

    public FullTimeEmployee(int empId, String name, double baseSalary, double hra, double da) {
        super(empId, name, baseSalary); 
        this.hra = hra;
        this.da = da;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + hra + da;
    }
}