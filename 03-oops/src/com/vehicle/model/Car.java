package com.vehicle.model;

public class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String registrationNumber, String ownerName,
               double baseUsageCharge, int numberOfDoors) {

        super(registrationNumber, ownerName, baseUsageCharge);

        if(numberOfDoors <= 0)
            throw new IllegalArgumentException("Invalid number of doors");

        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Vehicle Type  : Car");
        System.out.println("Doors         : " + numberOfDoors);
        System.out.println("--------------------------------");
    }
}
