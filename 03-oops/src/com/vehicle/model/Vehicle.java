package com.vehicle.model;

public class Vehicle {

    private String registrationNumber;
    private String ownerName;
    private double baseUsageCharge;

    public Vehicle(String registrationNumber, String ownerName, double baseUsageCharge) {

        if(registrationNumber == null || registrationNumber.trim().isEmpty())
            throw new IllegalArgumentException("Invalid registration number");

        if(ownerName == null || ownerName.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty");

        if(baseUsageCharge <= 0)
            throw new IllegalArgumentException("Usage charge must be positive");

        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.baseUsageCharge = baseUsageCharge;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBaseUsageCharge() {
        return baseUsageCharge;
    }

    public void displayDetails() {

        System.out.println("Registration No : " + registrationNumber);
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Base Charge     : " + baseUsageCharge);
    }
}