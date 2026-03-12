package com.BasicArray;

import java.util.Scanner;

public class InsuranceRiskPortfolioAnalyzer {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numberOfCustomer = scanner.nextInt();

        if (numberOfCustomer <= 0) {
            System.out.println("Number of customers must be positive.");
            return;
        }

        int[] ages = new int[numberOfCustomer];
        int[] riskScores = new int[numberOfCustomer];

        System.out.println("Enter age and risk score for each customer:");

        for (int i = 0; i < numberOfCustomer; i++) {
            System.out.print("Customer " + i + " age: ");
            ages[i] = scanner.nextInt();

            System.out.print("Customer " + i + " risk score (0-100): ");
            riskScores[i] = scanner.nextInt();

            if (ages[i] < 0) {
                System.out.println("Invalid age entered.");
                return;
            }

            if (riskScores[i] < 0 || riskScores[i] > 100) {
                System.out.println("Risk score must be between 0 and 100.");
                return;
            }
        }

        int highRiskYouthCount = 0;
        int seniorRiskCount = 0;
        int veryHighRiskCount = 0;
        int normalRiskCount = 0;

        int totalRiskScore = 0;
        int maxRiskScore = Integer.MIN_VALUE;
        int maxRiskIndex = -1;

        System.out.println("\nCustomer Risk Classification:");

        for (int i = 0; i < numberOfCustomer; i++) {
            int age = ages[i];
            int risk = riskScores[i];
            totalRiskScore += risk;

            if (risk > maxRiskScore) {
                maxRiskScore = risk;
                maxRiskIndex = i;
            }

            String category;

            if (age < 25 && risk > 70) {
                category = "High Risk Youth";
                highRiskYouthCount++;
            } 
            else if (age >= 60) {
                category = "Senior Risk";
                seniorRiskCount++;
            } 
            else if (risk >= 85) {
                category = "Very High Risk";
                veryHighRiskCount++;
            } 
            else {
                category = "Normal Risk";
                normalRiskCount++;
            }

            System.out.println("Customer " + i + " → " + category);
        }

        double averageRisk = (double) totalRiskScore / numberOfCustomer;

        System.out.println("\n---- Summary ----");
        System.out.println("High Risk Youth Count: " + highRiskYouthCount);
        System.out.println("Senior Risk Count: " + seniorRiskCount);
        System.out.println("Very High Risk Count: " + veryHighRiskCount);
        System.out.println("Normal Risk Count: " + normalRiskCount);
        System.out.println("Average Risk Score: " + averageRisk);
        System.out.println("Index of Highest Risk Customer: " + maxRiskIndex);
    }

}
