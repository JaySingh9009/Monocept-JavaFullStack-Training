package com.Interfaces.test;

import java.util.Scanner;

import com.Interfaces.model.ExamEvaluator;
import com.Interfaces.model.OnlineQuiz;
import com.Interfaces.model.PracticalExam;
import com.Interfaces.model.TheoryExam;

public class MainExamApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("\n=== Exam Evaluation System ===");
            System.out.println("1. Theory Exam");
            System.out.println("2. Practical Exam");
            System.out.println("3. Online Quiz");
            System.out.println("4. Exit");
            System.out.print("Select exam type (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number (1-4).");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 4) {
                exit = true;
                System.out.println("Exiting Exam System 👋");
                break;
            }

            ExamEvaluator evaluator = null;
            String examName = "";

            switch (choice) {
                case 1:
                    evaluator = new TheoryExam();
                    examName = "Theory Exam";
                    System.out.print("Enter marks (0-100): ");
                    break;
                case 2:
                    evaluator = new PracticalExam();
                    examName = "Practical Exam";
                    System.out.print("Enter marks (0-50): ");
                    break;
                case 3:
                    evaluator = new OnlineQuiz();
                    examName = "Online Quiz";
                    System.out.print("Enter marks (0-20): ");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 to 4.");
                    continue;
            }

            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid marks. Please enter numeric value.");
                scanner.next();
                continue;
            }

            double marks = scanner.nextDouble();

            evaluator.evaluateMarks(marks);  
            evaluator.calculateGrade();      
        }

        scanner.close();
    }
}