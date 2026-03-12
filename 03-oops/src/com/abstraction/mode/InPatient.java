package com.abstraction.mode;

public class InPatient extends Patient {

    private double roomCharges;

    public InPatient(int patientId, String name, double roomCharges) {
        super(patientId, name);
        this.roomCharges = roomCharges;
    }

    @Override
    public double calculateCharges() {

        if (roomCharges <= 0) {
            System.out.println("Invalid room charges for InPatient.");
            return 0;
        }

        double baseTreatmentCharge = 2000; 
        return baseTreatmentCharge + roomCharges;
    }
}