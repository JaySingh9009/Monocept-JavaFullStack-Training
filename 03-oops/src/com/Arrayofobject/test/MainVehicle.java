package com.Arrayofobject.test;

import java.util.Scanner;

import com.Arrayofobject.model.Car;
import com.Arrayofobject.model.Motorcycle;
import com.Arrayofobject.model.Truck;
import com.Arrayofobject.model.Vehicle;

public class MainVehicle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vehicles passing through toll: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of vehicles must be greater than 0.");
            return;
        }

        Vehicle[] vehicles = new Vehicle[n];
        String[] usedVehicleNumbers = new String[n];
        int usedCount = 0;

        String indianVehicleRegex = "^(?:[A-Z]{2}\\s?\\d{1,2}\\s?[A-Z]{1,2}\\s?\\d{4}|BH\\s?\\d{2}\\s?[A-Z]{2}\\s?\\d{4})$";

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");
            System.out.print("Choose vehicle type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Must be a number.");
                return;
            }

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid vehicle type selected.");
                return;
            }

            System.out.print("Enter vehicle number (e.g. MH12AB1234): ");
            scanner.nextLine(); // clear buffer
            String vehicleNumber = scanner.nextLine().trim().toUpperCase();

            if (vehicleNumber.isEmpty()) {
                System.out.println("Vehicle number cannot be empty.");
                return;
            }

            if (!vehicleNumber.matches(indianVehicleRegex)) {
                System.out.println("Invalid Indian vehicle number format.");
                System.out.println("Valid examples: MH12AB1234, DL 3C AA 9999, BH12AB1234");
                return;
            }

            boolean isDuplicate = false;
            for (int j = 0; j < usedCount; j++) {
                if (usedVehicleNumbers[j].equals(vehicleNumber)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Duplicate vehicle number detected. Entry not allowed.");
                return;
            }

            usedVehicleNumbers[usedCount++] = vehicleNumber;

            if (choice == 1) {
                vehicles[i] = new Car(vehicleNumber);
            } 
            else if (choice == 2) {
                vehicles[i] = new Truck(vehicleNumber);
            } 
            else {
                vehicles[i] = new Motorcycle(vehicleNumber);
            }
        }

        System.out.println("\n--- Toll Processing ---");

        for (int i = 0; i < vehicles.length; i++) {
            double toll = vehicles[i].calculateToll(); 
            System.out.println("Toll for " + vehicles[i].getVehicleNumber() + " = ₹" + toll);

            Vehicle.totalVehiclesProcessed++;
            Vehicle.totalTollCollected += toll;
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total Vehicles Processed: " + Vehicle.totalVehiclesProcessed);
        System.out.println("Total Toll Collected: ₹" + Vehicle.totalTollCollected);

        scanner.close();
    }
}