package com.constructor.test;

import java.util.Scanner;
import com.constructor.model.InsuranceClaim;
import com.constructor.model.CorporateClaim;

public class MainInsuranceClaim {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Claim Type:");
        System.out.println("1. Normal Insurance Claim");
        System.out.println("2. Corporate Claim");

        int choice;
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid option (1 or 2):");
            scanner.next();
        }
        choice = scanner.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please select 1 or 2. Claim not created.");
            scanner.close();
            return;
        }

        System.out.print("Enter Policy Number (positive integer): ");
        int policyNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer policy number:");
            scanner.next();
        }
        policyNumber = scanner.nextInt();

        if (policyNumber <= 0) {
            System.out.println("Policy number must be positive. Claim not created.");
            scanner.close();
            return;
        }

        System.out.print("Enter Claim Amount: ");
        double claimAmount;
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid claim amount:");
            scanner.next();
        }
        claimAmount = scanner.nextDouble();

        if (claimAmount < 0) {
            System.out.println("Claim amount cannot be negative. Claim not created.");
            scanner.close();
            return;
        }

        if (choice == 1) {
            new InsuranceClaim(policyNumber, claimAmount);
            System.out.println("\nInsurance Claim created successfully!");
        } 
        else { 

            System.out.print("Enter Processing Fee: ");
            double fee;
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid processing fee:");
                scanner.next();
            }
            fee = scanner.nextDouble();

            new CorporateClaim(policyNumber, claimAmount, fee);
            System.out.println("\nCorporate Claim created successfully!");
        }

        scanner.close();
    }
}
