package com.Interfaces.test;

import java.util.Scanner;

import com.Interfaces.model.Controllable;
import com.Interfaces.model.Fan;
import com.Interfaces.model.Light;
import com.Interfaces.model.Speaker;
import com.Interfaces.model.TV;

class MainSmartHomeController {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("\n=== Smart Home Device Controller ===");
            System.out.println("1. Light");
            System.out.println("2. Fan");
            System.out.println("3. TV");
            System.out.println("4. Speaker");
            System.out.println("5. Exit");
            System.out.print("Select a device (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            Controllable device = null;
            String deviceName = "";

            switch (choice) {
                case 1:
                    device = new Light();
                    deviceName = "Light";
                    System.out.println("Valid modes for Light: Dim, Bright");
                    break;
                case 2:
                    device = new Fan();
                    deviceName = "Fan";
                    System.out.println("Valid modes for Fan: Low, Medium, High");
                    break;
                case 3:
                    device = new TV();
                    deviceName = "TV";
                    System.out.println("Valid modes for TV: HD, FullHD, 4K");
                    break;
                case 4:
                    device = new Speaker();
                    deviceName = "Speaker";
                    System.out.println("Valid modes for Speaker: LowBass, Bass, HighBass");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Smart Home Controller. Bye 👋");
                    continue;
                default:
                    System.out.println("Invalid choice. Please select between 1 to 5.");
                    continue;
            }

            System.out.print("Enter mode for " + deviceName + ": ");
            String mode = scanner.nextLine().trim();

            while (mode.isEmpty()) {
                System.out.print("Mode cannot be empty. Enter again: ");
                mode = scanner.nextLine().trim();
            }

            device.turnOn();
            device.setMode(mode);   
            device.turnOff();
        }

        scanner.close();
    }
}