package com.constructor.model;

public class CorporateClaim extends InsuranceClaim {

    private double processingFee;

    public CorporateClaim(int policyNumber, double claimAmount, double processingFee) {
        super(policyNumber, claimAmount);  // parent initialization first

        if (processingFee < 0) {
            System.out.println("Processing fee cannot be negative. Setting fee to 0.");
            this.processingFee = 0;
            return;
        }

        this.processingFee = processingFee;
    }
}
