package com.abstraction.mode;


public class Bus extends Transport {

    private double distanceInKm;

    public Bus(String routeId, double baseFare, double distanceInKm) {
        super(routeId, baseFare);
        this.distanceInKm = distanceInKm;
    }

    @Override
    public double calculateFare() {

        if (distanceInKm <= 0 || baseFare <= 0) {
            System.out.println("Invalid distance or base fare for Bus.");
            return 0;
        }

        double perKmRate = 5; 
        return baseFare + (distanceInKm * perKmRate);
    }
}
