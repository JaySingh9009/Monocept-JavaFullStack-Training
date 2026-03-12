package com.Interfaces.test;

import java.util.Scanner;

import com.Interfaces.model.CreditCardPayment;
import com.Interfaces.model.DebitCardPayment;
import com.Interfaces.model.Payment;
import com.Interfaces.model.UPIPayment;

public class MainPaymentApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number (1-4).");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting application. Thank you!");
                break;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please select between 1 and 4.");
                continue;
            }

            System.out.print("Enter amount to pay: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount. Please enter a numeric value.");
                scanner.next(); 
                continue;
            }

            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Amount must be greater than 0.");
                continue;
            }

            Payment payment;

            if (choice == 1) {
                payment = new CreditCardPayment();
            } 
            else if (choice == 2) {
                payment = new DebitCardPayment();
            } 
            else {
                payment = new UPIPayment();
            }

            System.out.println("\n--- Processing Payment ---");
            payment.processPayment(amount);
        }

        scanner.close();
    }
}