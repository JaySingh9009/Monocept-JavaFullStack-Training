package com.Arrayofobject.model;
public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateToll(double baseRate) {
        return baseRate * 0.5;   
    }

    @Override
    public double calculateToll() {
        return calculateToll(50.0);
    }
}