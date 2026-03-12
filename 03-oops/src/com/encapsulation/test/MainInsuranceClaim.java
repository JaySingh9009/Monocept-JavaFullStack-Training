package com.encapsulation.test;

import java.util.Scanner;
import com.encapsulation.model.InsuranceClaim;

public class MainInsuranceClaim {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String claimId;
        while (true) {
            System.out.print("Enter Claim ID: ");
            claimId = scanner.nextLine().trim();
            if (!claimId.isEmpty()) break;
            System.out.println("Claim ID cannot be empty. Please try again.");
        }

        System.out.print("Enter Policy Number: ");
        int policyNo = scanner.nextInt();

        double claimAmount;
        while (true) {
            System.out.print("Enter Claim Amount: ");
            if (scanner.hasNextDouble()) {
                claimAmount = scanner.nextDouble();
                if (claimAmount >= 0) break;
                System.out.println("Claim amount cannot be negative. Try again.");
            } else {
                System.out.println("Please enter a valid numeric amount.");
                scanner.next(); 
            }
        }

        InsuranceClaim claim = new InsuranceClaim(claimId, policyNo, claimAmount);

        if (!claim.isValidClaim()) {
            System.out.println("Claim creation failed. Exiting...");
            scanner.close();
            return;
        }

        System.out.println("\nClaim created successfully!");
        System.out.println("Claim ID: " + claim.getClaimId());
        System.out.println("Current Status: " + claim.getClaimStatus());

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Approve Claim");
            System.out.println("2. Reject Claim");
            System.out.println("3. Settle Claim");
            System.out.println("4. Check Status");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option (1-5):");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double approvedAmount;
                    while (true) {
                        System.out.print("Enter Approved Amount: ");
                        if (scanner.hasNextDouble()) {
                            approvedAmount = scanner.nextDouble();
                            if (approvedAmount >= 0) break;
                            System.out.println("Approved amount cannot be negative.");
                        } else {
                            System.out.println("Please enter a valid number.");
                            scanner.next();
                        }
                    }
                    claim.approveClaim(approvedAmount);
                    break;

                case 2:
                    claim.rejectClaim();
                    break;

                case 3:
                    claim.settleClaim();
                    break;

                case 4:
                    System.out.println("Current Status: " + claim.getClaimStatus());
                    System.out.println("Approved Amount: " + claim.getApprovedAmount());
                    break;

                case 5:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
