package com.abstraction.mode;
public class Taxi extends Transport {

    private double distanceInKm;
    private double timeInMinutes;

    public Taxi(String routeId, double baseFare, double distanceInKm, double timeInMinutes) {
        super(routeId, baseFare);
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
    }

    @Override
    public double calculateFare() {

        if (distanceInKm <= 0 || timeInMinutes <= 0 || baseFare <= 0) {
            System.out.println("Invalid inputs for Taxi fare calculation.");
            return 0;
        }

        double perKmRate = 12;   
        double perMinuteRate = 1; 
        return baseFare + (distanceInKm * perKmRate) + (timeInMinutes * perMinuteRate);
    }
}