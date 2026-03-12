package com.abstraction.mode;

public class EmergencyPatient extends Patient {

    private double emergencySurcharge;

    public EmergencyPatient(int patientId, String name, double emergencySurcharge) {
        super(patientId, name);
        this.emergencySurcharge = emergencySurcharge;
    }

    @Override
    public double calculateCharges() {

        if (emergencySurcharge <= 0) {
            System.out.println("Invalid emergency surcharge.");
            return 0;
        }

        double baseEmergencyCharge = 3000; 
        return baseEmergencyCharge + emergencySurcharge;
    }
}
