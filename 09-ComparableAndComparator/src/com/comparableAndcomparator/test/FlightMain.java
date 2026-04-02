package com.comparableAndcomparator.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.comparableAndcomparator.model.Flight;
import com.comparableAndcomparator.model.FlightComparator;

public class FlightMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Flight> list = new ArrayList<>();

        int n;
        while (true) {
            System.out.print("Enter number of flights: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0) {
                    break;
                } else {
                    System.out.println("Number of flights must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {

            String airline;
            while (true) {
                System.out.print("Enter airline name: ");
                airline = sc.nextLine();

                if (!airline.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Airline name cannot be empty.");
                }
            }

            double fare;
            while (true) {
                System.out.print("Enter fare: ");
                if (sc.hasNextDouble()) {
                    fare = sc.nextDouble();
                    sc.nextLine();

                    if (fare >= 0) {
                        break;
                    } else {
                        System.out.println("Fare cannot be negative.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid fare.");
                    sc.nextLine();
                }
            }

            list.add(new Flight(airline, fare));
        }

        Collections.sort(list, new FlightComparator());

        System.out.println("\nFlights sorted by fare in descending order:");
        for (Flight f : list) {
            System.out.println(f);
        }

        sc.close();
    }
}