package com.BasicArray;

import java.util.Scanner;

public class StudentPerformanceHeatmap {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be positive.");
            return;
        }

        final int SUBJECTS = 5;
        int[][] marks = new int[numberOfStudents][SUBJECTS];

        System.out.println("Enter marks for each student (5 subjects):");

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + i + ":");
            for (int j = 0; j < SUBJECTS; j++) {
                System.out.print("  Subject " + (j + 1) + " marks: ");
                marks[i][j] = scanner.nextInt();

                if (marks[i][j] < 0 || marks[i][j] > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    return;
                }
            }
        }

        int distinctionCount = 0;

        double highestSubjectAverage = Double.MIN_VALUE;
        int bestSubjectIndex = -1;

        double[] subjectTotals = new double[SUBJECTS];

        System.out.println("\nStudent Results:");

        for (int i = 0; i < numberOfStudents; i++) {

            int total = 0;
            boolean hasFailed = false;

            for (int j = 0; j < SUBJECTS; j++) {
                total += marks[i][j];
                subjectTotals[j] += marks[i][j];

                if (marks[i][j] < 35) {
                    hasFailed = true;
                }
            }

            double average = (double) total / SUBJECTS;
            String result;

            if (hasFailed) {
                result = "Fail";
            } 
            else if (average >= 85) {
                result = "Distinction";
                distinctionCount++;
            } 
            else if (average >= 60) {
                result = "First Class";
            } 
            else if (average >= 50) {
                result = "Second Class";
            } 
            else {
                result = "Fail";
            }

            System.out.println("Student " + i + " : " + result + " (Average: " + average + ")");
        }

        for (int j = 0; j < SUBJECTS; j++) {
            double subjectAverage = subjectTotals[j] / numberOfStudents;

            if (subjectAverage > highestSubjectAverage) {
                highestSubjectAverage = subjectAverage;
                bestSubjectIndex = j;
            }
        }

        System.out.println("\n---- Summary ----");
        System.out.println("Number of Distinctions: " + distinctionCount);
        System.out.println("Subject with Highest Overall Average: Subject " + (bestSubjectIndex + 1));
        System.out.println("Highest Subject Average: " + highestSubjectAverage);
    }
}
