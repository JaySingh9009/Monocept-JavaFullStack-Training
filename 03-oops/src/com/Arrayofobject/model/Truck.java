package com.Arrayofobject.model;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateToll(double baseRate) {
        return baseRate * 2;  
    }

    @Override
    public double calculateToll() {
        return calculateToll(50.0);  
    }
}