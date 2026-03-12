package com.Arrayofobject.model;
public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber);  
    }

    @Override
    public double calculateToll(double baseRate) {
        return baseRate;   
    }

    @Override
    public double calculateToll() {
        return calculateToll(50.0); 
    }
}