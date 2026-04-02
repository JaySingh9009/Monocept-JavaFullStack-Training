package com.HospitalAppointmentSystem.model;

public class GeneralConsultation extends HospitalService implements ServiceValidation {

    public GeneralConsultation(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        super(serviceId, patientName, consultationFee);
        System.out.println("GeneralConsultation Constructor Called");
    }

    @Override
    public double calculateTotalCost() {

        return consultationFee;
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 200;
    }
}
