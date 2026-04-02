package com.streamApi.EmployeeAssignment.model;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double salary;
    private int experience;
    private boolean activeStatus;

    public Employee(int employeeId, String name, String department,
                    double salary, int experience, boolean activeStatus) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
        this.activeStatus = activeStatus;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public boolean isActiveStatus() { return activeStatus; }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + department +
                " | Rs." + salary + " | Exp: " + experience +
                " | Active: " + activeStatus;
    }
}
