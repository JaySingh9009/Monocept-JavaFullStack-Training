package com.abstraction.mode;


public abstract class Patient {

    private int patientId;
    private String name;

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public void generateBill() {

        double baseCharges = calculateCharges();

        if (baseCharges <= 0) {
            System.out.println("Invalid charges for patient: " + name);
            return;
        }

        double tax = baseCharges * 0.05; 
        double finalAmount = baseCharges + tax;

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Base Charges: " + baseCharges);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Final Bill Amount: " + finalAmount);
    }

    public abstract double calculateCharges();
}