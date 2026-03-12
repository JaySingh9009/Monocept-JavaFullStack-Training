package com.abstraction.mode;


public class Metro extends Transport {

    private int numberOfStations;

    public Metro(String routeId, double baseFare, int numberOfStations) {
        super(routeId, baseFare);
        this.numberOfStations = numberOfStations;
    }

    @Override
    public double calculateFare() {

        if (numberOfStations <= 0 || baseFare <= 0) {
            System.out.println("Invalid number of stations or base fare for Metro.");
            return 0;
        }

        double perStationRate = 10; 
        return baseFare + (numberOfStations * perStationRate);
    }
}