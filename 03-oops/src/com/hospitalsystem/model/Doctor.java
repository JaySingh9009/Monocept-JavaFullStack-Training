package com.hospitalsystem.model;

public class Doctor extends Staff {

    private String specialization;

    public Doctor(int id, String name, String department, String specialization) {

        super(id, name, department); // constructor chaining

        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization required");

        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Role            : Doctor");
        System.out.println("Specialization  : " + specialization);
        System.out.println("--------------------------------");
    }
}
