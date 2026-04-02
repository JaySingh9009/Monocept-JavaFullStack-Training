package com.HospitalAppointmentSystem.model;

public class DiagnosticTest extends HospitalService implements ServiceValidation {

    public DiagnosticTest(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
        System.out.println("DiagnosticTest Constructor Called");
    }

    @Override
    public double calculateTotalCost() {

        return consultationFee + 300;
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 500;
    }
}