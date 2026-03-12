package com.Interfaces.test;


import java.util.Scanner;

import com.Interfaces.model.Bike;
import com.Interfaces.model.Car;
import com.Interfaces.model.Vehicle;

public class MainVehicleApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number.");
            return;
        }

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of vehicles must be greater than 0.");
            return;
        }

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.print("Choose vehicle type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Must be a number.");
                return;
            }

            int choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Select 1 or 2 only.");
                return;
            }

            if (choice == 1) {
                System.out.print("Enter fuel type for Car (Petrol/Diesel): ");
                String fuel = scanner.next();

                if (!(fuel.equalsIgnoreCase("Petrol") || fuel.equalsIgnoreCase("Diesel"))) {
                    System.out.println("Invalid fuel type. Car fuel must be Petrol or Diesel.");
                    return;
                }

                vehicles[i] = new Car(fuel.substring(0,1).toUpperCase() + fuel.substring(1).toLowerCase());
            } 
            else {
                vehicles[i] = new Bike();
            }
        }

        System.out.println("\n---------------------");

        for (Vehicle v : vehicles) {
            v.start();                         
            System.out.println("Fuel Type: " + v.fuelType());
            v.stop();                          
            System.out.println("----------------------------");
        }

        scanner.close();
    }
}