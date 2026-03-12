package com.abstraction.test;

import java.util.Scanner;

import com.abstraction.mode.CreditCardPayment;
import com.abstraction.mode.Payment;
import com.abstraction.mode.UPIPayment;
import com.abstraction.mode.WalletPayment;

public class MainPaymentApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number.");
            return;
        }

        int numberOfPayments = scanner.nextInt();

        if (numberOfPayments <= 0) {
            System.out.println("Number of payments must be greater than 0.");
            return;
        }

        Payment[] payments = new Payment[numberOfPayments];

        for (int i = 0; i < numberOfPayments; i++) {

            System.out.println("\nPayment " + (i + 1));
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Wallet");
            System.out.print("Choose payment type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice.");
                return;
            }

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Choose between 1 to 3 only.");
                return;
            }

            System.out.print("Enter payment amount: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount. Enter numeric value only.");
                return;
            }

            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount. Amount must be greater than 0.");
                return;
            }

            switch (choice) {
            case 1:
                payments[i] = new CreditCardPayment(amount);
                break;
            case 2:
                payments[i] = new UPIPayment(amount);
                break;
            case 3:
                payments[i] = new WalletPayment(amount);
                break;
            default:
                System.out.println("Invalid payment type.");
                return;
        }
        }

        System.out.println("\n--- Processing Payments ---");
        for (int i = 0; i < numberOfPayments; i++) {
            payments[i].processPayment();     
            payments[i].generateReceipt();   
            System.out.println("----------------------------");
        }
    }
}