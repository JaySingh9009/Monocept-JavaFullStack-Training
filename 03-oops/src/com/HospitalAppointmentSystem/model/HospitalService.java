package com.HospitalAppointmentSystem.model;

public abstract class HospitalService {

    public int serviceId;
    public String patientName;
    protected double consultationFee;

    static {
        System.out.println("Hospital System Configuration Loaded...");
    }

    public HospitalService(int serviceId, String patientName, double consultationFee)
            throws InvalidServiceException {

        System.out.println("HospitalService Constructor Called");

        if (consultationFee <= 0) {
            throw new InvalidServiceException("Consultation fee must be greater than 0");
        }

        this.serviceId = serviceId;
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }

    public abstract double calculateTotalCost();
}