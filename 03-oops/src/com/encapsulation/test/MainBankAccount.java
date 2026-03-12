package com.encapsulation.test;

import java.util.Scanner;
import com.encapsulation.model.BankAccount;

public class MainBankAccount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number for balance:");
            scanner.next(); 
        }
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);

        if (!account.isValidAccount()) {
            System.out.println("Account creation failed. Exiting...");
            scanner.close();
            return;
        }

        System.out.println("\nAccount Created Successfully!");
        System.out.println("Account No: " + account.getAccountNumber());
        System.out.println("Holder: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid menu option (1-4):");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Enter a valid number:");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Enter a valid number:");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the banking system 👋");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1–4.");
            }
        }
    }
}
