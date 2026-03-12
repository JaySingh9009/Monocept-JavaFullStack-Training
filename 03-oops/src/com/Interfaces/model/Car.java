package com.Interfaces.model;


public class Car implements Vehicle {

    private String fuel;  // Petrol or Diesel

    public Car(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public void start() {
        System.out.println("Car is starting with key ignition.");
    }

    @Override
    public void stop() {
        System.out.println("Car has stopped.");
    }

    @Override
    public String fuelType() {
        return fuel;
    }
}
