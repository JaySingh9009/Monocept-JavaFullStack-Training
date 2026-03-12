package com.banksystem.test;

import java.util.Scanner;

import com.banksystem.model.*;

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        sc.nextLine();

        Account[] accounts = new Account[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter account details " + (i+1));

            int accNo;
            boolean duplicate;

            do {

                duplicate = false;

                System.out.print("Account Number: ");
                accNo = sc.nextInt();
                sc.nextLine();

                if(accNo <= 0) {
                    System.out.println("Invalid account number");
                    duplicate = true;
                    continue;
                }

                for(int j = 0; j < i; j++) {

                    if(accounts[j].getAccountNumber() == accNo) {
                        System.out.println("Duplicate account number");
                        duplicate = true;
                        break;
                    }
                }

            } while(duplicate);

            System.out.print("Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.println("Choose Account Type");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");

            int type = sc.nextInt();

            try {

                if(type == 1) {

                    System.out.print("Interest Rate: ");
                    double rate = sc.nextDouble();

                    accounts[i] = new SavingsAccount(accNo, name, balance, rate);
                }

                else if(type == 2) {

                    System.out.print("Overdraft Limit: ");
                    double limit = sc.nextDouble();

                    accounts[i] = new CurrentAccount(accNo, name, balance, limit);
                }

                else {
                    System.out.println("Invalid type");
                    i--;
                }

            } catch(Exception e) {

                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n------ Account Details ------");

        for(Account a : accounts) {
            a.displayDetails(); // runtime polymorphism
        }

        sc.close();
    }
}
