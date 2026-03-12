package com.hospitalsystem.model;

public class Nurse extends Staff {

    private String shift;

    public Nurse(int id, String name, String department, String shift) {

        super(id, name, department);

        if (shift == null || shift.trim().isEmpty())
            throw new IllegalArgumentException("Shift cannot be empty");

        this.shift = shift;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Role  : Nurse");
        System.out.println("Shift : " + shift);
        System.out.println("--------------------------------");
    }
}
