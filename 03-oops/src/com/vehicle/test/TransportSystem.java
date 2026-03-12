package com.vehicle.test;

import java.util.Scanner;
import com.vehicle.model.*;

public class TransportSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter details for vehicle " + (i+1));

            System.out.print("Registration Number: ");
            String reg = sc.nextLine();

            System.out.print("Owner Name: ");
            String owner = sc.nextLine();

            System.out.print("Base Usage Charge: ");
            double charge = sc.nextDouble();

            System.out.println("Choose Vehicle Type");
            System.out.println("1. Car");
            System.out.println("2. Bike");

            int type = sc.nextInt();

            try {

                if(type == 1) {

                    System.out.print("Number of Doors: ");
                    int doors = sc.nextInt();

                    vehicles[i] = new Car(reg, owner, charge, doors);
                }

                else if(type == 2) {

                    System.out.print("Engine Capacity (cc): ");
                    int capacity = sc.nextInt();

                    vehicles[i] = new Bike(reg, owner, charge, capacity);
                }

                else {

                    System.out.println("Invalid vehicle type");
                    i--;
                }

            } catch(Exception e) {

                System.out.println("Error: " + e.getMessage());
                i--;
            }

            sc.nextLine();
        }

        System.out.println("\n------ Registered Vehicles ------");

        for(Vehicle v : vehicles) {
            v.displayDetails(); 
        }

        sc.close();
    }
}