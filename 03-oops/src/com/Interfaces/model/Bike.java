package com.Interfaces.model;

public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike is starting with self/kick.");
    }

    @Override
    public void stop() {
        System.out.println("Bike has stopped.");
    }

    @Override
    public String fuelType() {
        return "Petrol";
    }
}