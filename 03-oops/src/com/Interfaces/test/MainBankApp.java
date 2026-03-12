package com.Interfaces.test;

import java.util.Scanner;
import com.Interfaces.model.AccountOperations;
import com.Interfaces.model.CurrentAccount;
import com.Interfaces.model.LoanAccount;
import com.Interfaces.model.SavingsAccount;

public class MainBankApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AccountOperations savings = null;
        AccountOperations current = null;
        AccountOperations loan = null;

        boolean exit = false;

        while (!exit) {

            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create / Access Savings Account");
            System.out.println("2. Create / Access Current Account");
            System.out.println("3. Create / Access Loan Account");
            System.out.println("4. Exit");
            System.out.print("Select option (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number (1-4).");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 4) {
                exit = true;
                System.out.println("Thank you for using the Banking System 👋");
                break;
            }

            AccountOperations selectedAccount = null;
            String accountName = "";

            switch (choice) {
                case 1:
                    if (savings == null) {
                        System.out.print("Enter initial balance for Savings Account: ");
                        double initBal = getValidAmount(scanner);
                        savings = new SavingsAccount(initBal);
                        System.out.println("Savings Account created successfully.");
                    }
                    selectedAccount = savings;
                    accountName = "Savings Account";
                    break;

                case 2:
                    if (current == null) {
                        System.out.print("Enter initial balance for Current Account: ");
                        double initBal = getValidAmount(scanner);
                        current = new CurrentAccount(initBal);
                        System.out.println("Current Account created successfully.");
                    }
                    selectedAccount = current;
                    accountName = "Current Account";
                    break;

                case 3:
                    if (loan == null) {
                        System.out.print("Enter initial loan amount: ");
                        double initLoan = getValidAmount(scanner);
                        loan = new LoanAccount(initLoan);
                        System.out.println("Loan Account created successfully.");
                    }
                    selectedAccount = loan;
                    accountName = "Loan Account";
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 to 4.");
                    continue;
            }

            boolean backToMenu = false;

            while (!backToMenu) {

                System.out.println("\n--- " + accountName + " Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Back to Main Menu");
                System.out.print("Choose operation (1-4): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number (1-4).");
                    scanner.next();
                    continue;
                }

                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = getValidAmount(scanner);
                        selectedAccount.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wit = getValidAmount(scanner);
                        selectedAccount.withdraw(wit);
                        break;

                    case 3:
                        selectedAccount.checkBalance();
                        break;

                    case 4:
                        backToMenu = true;
                        break;

                    default:
                        System.out.println("Invalid option. Choose between 1 to 4.");
                }
            }
        }

        scanner.close();
    }

    private static double getValidAmount(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid amount. Please enter a numeric value: ");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        while (amount < 0) {
            System.out.print("Amount cannot be negative. Enter again: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid amount. Please enter a numeric value: ");
                scanner.next();
            }
            amount = scanner.nextDouble();
        }
        return amount;
    }
}