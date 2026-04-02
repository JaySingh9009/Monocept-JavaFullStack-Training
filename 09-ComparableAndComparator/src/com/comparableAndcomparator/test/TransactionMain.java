package com.comparableAndcomparator.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.comparableAndcomparator.model.Transaction;
import com.comparableAndcomparator.model.TransactionComparator;

public class TransactionMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Transaction> list = new ArrayList<>();

        int n;

        while (true) {
            System.out.print("Enter number of transactions: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0)
                    break;
                else
                    System.out.println("Number must be positive.");
            } else {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {

            int id;

            while (true) {
                System.out.print("Enter transaction ID: ");

                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                    sc.nextLine();

                    if (id >= 0)
                        break;
                    else
                        System.out.println("ID cannot be negative.");
                } else {
                    System.out.println("Invalid ID.");
                    sc.nextLine();
                }
            }

            double amount;

            while (true) {
                System.out.print("Enter amount: ");

                if (sc.hasNextDouble()) {
                    amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount >= 0)
                        break;
                    else
                        System.out.println("Amount cannot be negative.");
                } else {
                    System.out.println("Invalid amount.");
                    sc.nextLine();
                }
            }

            list.add(new Transaction(id, amount));
        }

        Collections.sort(list, new TransactionComparator());

        System.out.println("\nSorted Transactions:");

        for (Transaction t : list) {
            System.out.println(t);
        }

        sc.close();
    }
}