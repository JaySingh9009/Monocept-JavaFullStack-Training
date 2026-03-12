package com.encapsulation.model;

public class InsuranceClaim {

    private final String claimId;

    private int policyNumber;
    private double claimAmount;
    private double approvedAmount;
    private ClaimStatus claimStatus;

    private boolean validClaim;   

    public enum ClaimStatus {
        FILED,
        APPROVED,
        REJECTED,
        SETTLED
    }

    public InsuranceClaim(String claimId, int policyNumber, double claimAmount) {

        this.claimId = claimId;

        if (claimId == null || claimId.trim().isEmpty()) {
            System.out.println("Claim ID cannot be empty");
            validClaim = false;
            return;
        }

        if (claimAmount < 0) {
            System.out.println("Claim amount cannot be negative");
            validClaim = false;
            return;
        }

        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimStatus = ClaimStatus.FILED;
        this.validClaim = true;
    }

    public boolean isValidClaim() {
        return validClaim;
    }

    public String getClaimId() {
        return claimId;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void approveClaim(double approvedAmount) {
        if (!validClaim) {
            System.out.println("Invalid claim. Operation not allowed.");
            return;
        }

        if (claimStatus == ClaimStatus.SETTLED) {
            System.out.println("Settled claim cannot be modified");
            return;
        }

        if (claimStatus != ClaimStatus.FILED) {
            System.out.println("Only FILED claim can be approved");
            return;
        }

        if (approvedAmount < 0 || approvedAmount > claimAmount) {
            System.out.println("Approved amount must be between 0 and claim amount");
            return;
        }

        this.approvedAmount = approvedAmount;
        this.claimStatus = ClaimStatus.APPROVED;
        System.out.println("Claim approved successfully");
    }

    public void rejectClaim() {
        if (!validClaim) {
            System.out.println("Invalid claim. Operation not allowed.");
            return;
        }

        if (claimStatus == ClaimStatus.SETTLED) {
            System.out.println("Settled claim cannot be modified");
            return;
        }

        if (claimStatus != ClaimStatus.FILED) {
            System.out.println("Only FILED claim can be rejected");
            return;
        }

        this.claimStatus = ClaimStatus.REJECTED;
        System.out.println("Claim rejected");
    }

    public void settleClaim() {
        if (!validClaim) {
            System.out.println("Invalid claim. Operation not allowed.");
            return;
        }

        if (claimStatus == ClaimStatus.SETTLED) {
            System.out.println("Settled claim cannot be modified");
            return;
        }

        if (claimStatus != ClaimStatus.APPROVED) {
            System.out.println("Only APPROVED claim can be settled");
            return;
        }

        this.claimStatus = ClaimStatus.SETTLED;
        System.out.println("Claim settled successfully");
    }
}
