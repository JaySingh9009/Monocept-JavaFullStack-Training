package com.Inheritance.model;



public class FullTimeEmployee extends Employee {

    private double basicSalary;
    private double houseRentAllowance;
    private double dearnessAllowance;

    public FullTimeEmployee(int empId, String name, double basicSalary, double houseRentAllowance, double dearnessAllowance) {
        super(empId, name);
        this.basicSalary = basicSalary;
        this.houseRentAllowance = houseRentAllowance;
        this.dearnessAllowance = dearnessAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + houseRentAllowance + dearnessAllowance;
    }
}
