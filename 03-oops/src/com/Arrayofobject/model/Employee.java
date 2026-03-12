package com.Arrayofobject.model;
public abstract class Employee {

    private int empId;
    private String name;
    protected double baseSalary;
    private static int totalEmployees = 0;

    public Employee(int empId, String name, double baseSalary) {
        this.empId = empId;
        this.name = name;
        this.baseSalary = baseSalary;
        totalEmployees++;
    }

    public abstract double calculateSalary();

    

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}
