package com.Arrayofobject.model;

public abstract class Vehicle {

    protected String vehicleNumber;

    public static int totalVehiclesProcessed = 0;
    public static double totalTollCollected = 0;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public double calculateToll() {
        return 0.0;
    }
    
    public abstract double calculateToll(double baseRate);

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}