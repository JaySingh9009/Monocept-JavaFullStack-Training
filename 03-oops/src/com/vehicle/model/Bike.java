package com.vehicle.model;

public class Bike extends Vehicle {

    private int engineCapacity;

    public Bike(String registrationNumber, String ownerName,
                double baseUsageCharge, int engineCapacity) {

        super(registrationNumber, ownerName, baseUsageCharge);

        if(engineCapacity <= 0)
            throw new IllegalArgumentException("Invalid engine capacity");

        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Vehicle Type    : Bike");
        System.out.println("Engine Capacity : " + engineCapacity + " cc");
        System.out.println("--------------------------------");
    }
}
