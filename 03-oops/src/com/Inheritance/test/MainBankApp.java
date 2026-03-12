package com.Inheritance.test;

import java.util.Scanner;
import com.Inheritance.model.*;  

public class MainBankApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int accountTypeChoice;
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid option (1 or 2):");
            scanner.next();
        }
        accountTypeChoice = scanner.nextInt();

        if (accountTypeChoice != 1 && accountTypeChoice != 2) {
            System.out.println("Invalid account type choice. Application exiting.");
            scanner.close();
            return;
        }

        System.out.print("Enter Account Number (positive integer): ");
        int accountNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer account number:");
            scanner.next();
        }
        accountNumber = scanner.nextInt();

        if (accountNumber <= 0) {
            System.out.println("Account number must be positive. Application exiting.");
            scanner.close();
            return;
        }

        scanner.nextLine(); 

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            System.out.println("Account holder name cannot be empty. Application exiting.");
            scanner.close();
            return;
        }

        System.out.print("Enter Initial Balance: ");
        double initialBalance;
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid numeric balance:");
            scanner.next();
        }
        initialBalance = scanner.nextDouble();

        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Application exiting.");
            scanner.close();
            return;
        }

        SavingAccount savingsAccount = null;
        CurrentAccount currentAccount = null;

        if (accountTypeChoice == 1) {
            savingsAccount = new SavingAccount(accountNumber, accountHolderName, initialBalance);
            System.out.println("\nSavings Account created successfully!");
          
        } else {
            System.out.print("Enter Overdraft Limit: ");
            double overdraftLimit;
            while (!scanner.hasNextDouble()) {
                System.out.println("Enter a valid overdraft limit:");
                scanner.next();
            }
            overdraftLimit = scanner.nextDouble();

            if (overdraftLimit < 0) {
                System.out.println("Overdraft limit cannot be negative. Application exiting.");
                scanner.close();
                return;
            }

            currentAccount = new CurrentAccount(accountNumber, accountHolderName, initialBalance, overdraftLimit);
            System.out.println("\nCurrent Account created successfully!");
         
        }
        
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");

            int operationChoice;
            while (!scanner.hasNextInt()) {
                System.out.println("Enter a valid option (1, 2, 3, or 4):");
                scanner.next();
            }
            operationChoice = scanner.nextInt();

            switch (operationChoice) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount;
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Enter a valid deposit amount:");
                        scanner.next();
                    }
                    depositAmount = scanner.nextDouble();

                    if (accountTypeChoice == 1) {
                        savingsAccount.deposit(depositAmount);
                       
                    } else {
                        currentAccount.deposit(depositAmount);
                        
                    }
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawalAmount;
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Enter a valid withdrawal amount:");
                        scanner.next();
                    }
                    withdrawalAmount = scanner.nextDouble();

                    if (accountTypeChoice == 1) {
                        savingsAccount.withdraw(withdrawalAmount);
                      
                    } else {
                        currentAccount.withdraw(withdrawalAmount);
                        
                    }
                    break;

                case 3:
                    if (accountTypeChoice == 1) {
                        savingsAccount.displayDetails();
                    } else {
                        currentAccount.displayDetails();
                    }
                    break;

                case 4:
                    continueOperations = false;
                    System.out.println("Exited from app");
                    break;

                default:
                    System.out.println("Invalid operation choice. Try again.");
            }
        }

        scanner.close();
    }
}
