package com.constructor.test;

import java.util.Scanner;
import com.constructor.model.BankAccount;
import com.constructor.model.PremiumAccount;

public class MainAccount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Account Type:");
        System.out.println("1. Normal Bank Account");
        System.out.println("2. Premium Account");

        int choice;
        while (!sc.hasNextInt()) {
            System.out.println("Enter a valid option (1 or 2):");
            sc.next();
        }
        choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.println("Do you want to enter initial balance?");
        System.out.println("1. Yes");
        System.out.println("2. No (default ₹0)");

        int balChoice;
        while (!sc.hasNextInt()) {
            System.out.println("Enter 1 or 2:");
            sc.next();
        }
        balChoice = sc.nextInt();

        double balance = 0;

        if (balChoice == 1) {
            System.out.print("Enter Initial Balance: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid balance:");
                sc.next();
            }
            balance = sc.nextDouble();

            // 🔴 If negative balance → stop flow here
            if (balance < 0) {
                System.out.println("Initial balance cannot be negative. Account not created.");
                sc.close();
                return;
            }
        }

        if (choice == 1) {
            // Normal Account
            if (balChoice == 1) {
                new BankAccount(accNo, name, balance);
                System.out.println("\nNormal Bank Account created successfully!");
            } else {
                new BankAccount(accNo, name); // default ₹0
                System.out.println("\nNormal Bank Account created with default balance ₹0!");
            }
        } 
        else if (choice == 2) {
            // Premium Account

            System.out.print("Enter Bonus Amount: ");
            double bonus;
            while (!sc.hasNextDouble()) {
                System.out.println("Please enter a valid bonus amount:");
                sc.next();
            }
            bonus = sc.nextDouble();

            PremiumAccount pAcc = new PremiumAccount(accNo, name, balance, bonus);
            System.out.println("\nPremium Account created successfully!");
        } 
        else {
            System.out.println("Invalid choice. Account not created.");
        }

        sc.close();
    }
}
