package com.BasicArray;

import java.util.Scanner;

public class SmartLoanEligibilityChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int numberOfApplicants = scanner.nextInt();

        if (numberOfApplicants <= 0) {
            System.out.println("Number of applicants must be positive.");
            return;
        }

        int[] creditScores = new int[numberOfApplicants];
        int[] monthlyIncomes = new int[numberOfApplicants];
        int[] existingLoans = new int[numberOfApplicants];

        System.out.println("Enter details for each applicant:");

        for (int i = 0; i < numberOfApplicants; i++) {
            System.out.print("Applicant " + i + " credit score: ");
            creditScores[i] = scanner.nextInt();

            System.out.print("Applicant " + i + " monthly income: ");
            monthlyIncomes[i] = scanner.nextInt();

            System.out.print("Applicant " + i + " existing loans: ");
            existingLoans[i] = scanner.nextInt();

            if (creditScores[i] < 0 || monthlyIncomes[i] < 0 || existingLoans[i] < 0) {
                System.out.println("Invalid input. Values cannot be negative.");
                return;
            }
        }

        int totalApprovals = 0;
        int totalRejections = 0;

        int bestApplicantIndex = -1;
        String bestCategory = ""; // "Instant Approval" or "Standard Review"

        System.out.println("\nLoan Eligibility Results:");

        for (int i = 0; i < numberOfApplicants; i++) {

            int credit = creditScores[i];
            int income = monthlyIncomes[i];
            int loans = existingLoans[i];

            boolean rejected;
            String result;

            if (credit < 600 || income < 25000 || loans >= 3) {
                result = "Rejected";
                totalRejections++;
                rejected = true;
            } 
            else {
                if (credit >= 800 && income > 100000) {
                    result = "Instant Approval";
                } else {
                    result = "Standard Review";
                }
                totalApprovals++;
                rejected = false;
            }

            System.out.println("Applicant " + i + " : " + result);

            // Find best approval profile based on priority rules
            if (!rejected) {

                if (bestApplicantIndex == -1) {
                    bestApplicantIndex = i;
                    bestCategory = result;
                } 
                else {
                    boolean isBetter = false;

                    // Prefer Instant Approval over Standard Review
                    if (bestCategory.equals("Standard Review") && result.equals("Instant Approval")) {
                        isBetter = true;
                    }
                    // Same category: compare credit score, income, loans
                    else if (bestCategory.equals(result)) {
                        if (credit > creditScores[bestApplicantIndex]) {
                            isBetter = true;
                        } 
                        else if (credit == creditScores[bestApplicantIndex]) {
                            if (income > monthlyIncomes[bestApplicantIndex]) {
                                isBetter = true;
                            } 
                            else if (income == monthlyIncomes[bestApplicantIndex] &&
                                     loans < existingLoans[bestApplicantIndex]) {
                                isBetter = true;
                            }
                        }
                    }

                    if (isBetter) {
                        bestApplicantIndex = i;
                        bestCategory = result;
                    }
                }
            }
        }

        System.out.println("\n---- Summary ----");
        System.out.println("Total Approvals: " + totalApprovals);
        System.out.println("Total Rejections: " + totalRejections);

        if (bestApplicantIndex != -1) {
            System.out.println("Best Approval Profile Applicant Index: " + bestApplicantIndex);
        } else {
            System.out.println("No applicant was approved.");
        }
    }
}
