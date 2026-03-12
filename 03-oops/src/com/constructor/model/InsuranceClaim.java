package com.constructor.model;

public class InsuranceClaim {

    private static int idCounter = 1000;

    private final int claimId;        
    private int policyNumber;        
    protected double claimAmount;
    protected String status;
    protected double approvedAmount;

    private InsuranceClaim() {
        this.claimId = ++idCounter;
        this.status = "Filed";
        this.approvedAmount = 0;
    }

    public InsuranceClaim(int policyNumber, double claimAmount) {
        this();  

        if (policyNumber <= 0) {
            System.out.println("Policy number must be positive. Claim not created.");
            return;
        }

        if (claimAmount < 0) {
            System.out.println("Claim amount cannot be negative. Claim not created.");
            return;
        }

        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
    }
}
