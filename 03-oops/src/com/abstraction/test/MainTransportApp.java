package com.abstraction.test;
import java.util.Scanner;

import com.abstraction.mode.Bus;
import com.abstraction.mode.Metro;
import com.abstraction.mode.Taxi;
import com.abstraction.mode.Transport;

public class MainTransportApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of trips: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number.");
            return;
        }

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of trips must be greater than 0.");
            return;
        }

        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nTrip " + (i + 1));
            System.out.println("1. Bus");
            System.out.println("2. Metro");
            System.out.println("3. Taxi");
            System.out.print("Choose transport type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice.");
                return;
            }

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Choose between 1 to 3 only.");
                return;
            }

            System.out.print("Enter Route ID (integer only): ");
            String routeId = scanner.next().trim();

            String routeIdRegex = "^[1-9]\\d*$";

            if (!routeId.matches(routeIdRegex)) {
                System.out.println("Invalid Route ID. Route ID must be a positive integer (e.g., 101).");
                return;
            }

            System.out.print("Enter Base Fare: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid base fare.");
                return;
            }

            double baseFare = scanner.nextDouble();

            if (baseFare <= 0) {
                System.out.println("Base fare must be greater than 0.");
                return;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Distance (km): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid distance.");
                        return;
                    }
                    double busDistance = scanner.nextDouble();
                    transports[i] = new Bus(routeId, baseFare, busDistance);
                    break;

                case 2:
                    System.out.print("Enter Number of Stations: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid number of stations.");
                        return;
                    }
                    int stations = scanner.nextInt();
                    transports[i] = new Metro(routeId, baseFare, stations);
                    break;

                case 3:
                    System.out.print("Enter Distance (km): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid distance.");
                        return;
                    }
                    double taxiDistance = scanner.nextDouble();

                    System.out.print("Enter Time (minutes): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid time.");
                        return;
                    }
                    double time = scanner.nextDouble();

                    transports[i] = new Taxi(routeId, baseFare, taxiDistance, time);
                    break;

                default:
                    System.out.println("Invalid transport type.");
                    return;
            }
        }

        System.out.println("\n--- Fare Calculation ---");
        for (int i = 0; i < n; i++) {
            transports[i].printTicket();   
            System.out.println("----------------------------");
        }
    }
}
