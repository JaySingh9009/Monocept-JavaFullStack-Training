package com.abstraction.mode;

public abstract class Transport {

    protected String routeId;
    protected double baseFare;

    public Transport(String routeId, double baseFare) {
        this.routeId = routeId;
        this.baseFare = baseFare;
    }

    public abstract double calculateFare();

    public void printTicket() {
        double fare = calculateFare();

        if (fare <= 0) {
            System.out.println("Invalid fare. Ticket cannot be generated.");
            return;
        }

        System.out.println("Route ID: " + routeId);
        System.out.println("Base Fare: " + baseFare);
        System.out.println("Total Fare: " + fare);
        System.out.println("Ticket generated successfully.");
    }
}
