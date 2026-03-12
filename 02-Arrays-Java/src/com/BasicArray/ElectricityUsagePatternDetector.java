package com.BasicArray;

import java.util.Scanner;

public class ElectricityUsagePatternDetector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int DAYS = 30;
        int[] usage = new int[DAYS];

        System.out.println("Enter electricity usage for 30 days:");

        for (int i = 0; i < DAYS; i++) {
            System.out.print("Day " + (i + 1) + " usage: ");
            usage[i] = scanner.nextInt();

            if (usage[i] < 0) {
                System.out.println("Usage cannot be negative.");
                return;
            }
        }

        int highConsumptionCount = 0;
        int totalUsage = 0;
        boolean overloadWarning = false;

        System.out.println("\nDaily Usage Classification:");

        int consecutiveHighDays = 0;

        for (int i = 0; i < DAYS; i++) {

            int value = usage[i];
            totalUsage += value;

            if (value > 500) {
                System.out.println("Day " + (i + 1) + " : High Consumption");
                highConsumptionCount++;
                consecutiveHighDays++;
            } 
            else if (value < 100) {
                System.out.println("Day " + (i + 1) + " : Low Usage Alert");
                consecutiveHighDays = 0;
            } 
            else {
                System.out.println("Day " + (i + 1) + " : Normal Usage");
                consecutiveHighDays = 0;
            }

            if (consecutiveHighDays == 3) {
                overloadWarning = true;
            }
        }

        double averageUsage = (double) totalUsage / DAYS;

        System.out.println("\n---- Monthly Summary ----");
        System.out.println("Monthly Average Usage: " + averageUsage);
        System.out.println("High Consumption Days Count: " + highConsumptionCount);

        if (overloadWarning) {
            System.out.println("Overload Warning Detected (3 consecutive high usage days).");
        } else {
            System.out.println("No Overload Warning Detected.");
        }

        if (averageUsage > 400) {
            System.out.println("Heavy Month Detected (Average usage > 400).");
        } else {
            System.out.println("Normal Month.");
        }
    }
}
