package com.HospitalAppointmentSystem.model;

public class Surgery extends HospitalService implements ServiceValidation {

    public Surgery(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
        System.out.println("Surgery Constructor Called");
    }

    @Override
    public double calculateTotalCost() {

        return consultationFee + (consultationFee * 0.5);
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 5000;
    }
}
