package com.BasicArray;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FraudTransactionDetector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int numberOfDays = scanner.nextInt();

        if (numberOfDays <= 0) {
            System.out.println("Number of days must be positive.");
            return;
        }

        double[] transactions = new double[numberOfDays];

        System.out.println("Enter transaction amounts for each day:");

        for (int i = 0; i < numberOfDays; i++) {
            System.out.print("Day " + (i + 1) + " transaction: ");
            transactions[i] = scanner.nextDouble();

            if (transactions[i] < 0) {
                System.out.println("Transaction amount cannot be negative.");
                return;
            }
        }

        List<Integer> suspiciousIndices = new ArrayList<>();
        boolean potentialFraudDetected = false;

        double total = 0.0;
        int consecutiveSuspicious = 0;

        System.out.println("\nDaily Transaction Analysis:");

        for (int i = 0; i < numberOfDays; i++) {
            double amount = transactions[i];
            total += amount;

            if (amount > 50000) {
                System.out.println("Day " + (i + 1) + " : Suspicious Transaction");
                suspiciousIndices.add(i);
                consecutiveSuspicious++;
            } else {
                System.out.println("Day " + (i + 1) + " : Normal Transaction");
                consecutiveSuspicious = 0;
            }

            if (consecutiveSuspicious == 2) {
                potentialFraudDetected = true;
            }
        }

        double average = total / numberOfDays;

        System.out.println("\n---- Summary ----");
        System.out.println("Average Daily Transaction Value: " + average);

        if (average > 40000) {
            System.out.println("High Value Account Detected (Average > 40000).");
        } else {
            System.out.println("Normal Value Account.");
        }

        if (potentialFraudDetected) {
            System.out.println("Potential Fraud Detected (2 consecutive suspicious transactions).");
        } else {
            System.out.println("No Fraud Pattern Detected.");
        }

        System.out.print("Suspicious Transaction Indices: ");
        if (suspiciousIndices.isEmpty()) {
            System.out.println("None");
        } else {
            for (int idx : suspiciousIndices) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }
}
