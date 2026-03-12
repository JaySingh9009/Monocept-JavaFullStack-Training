package com.abstraction.test;

import java.util.Scanner;

import com.abstraction.mode.EmergencyPatient;
import com.abstraction.mode.InPatient;
import com.abstraction.mode.OutPatient;
import com.abstraction.mode.Patient;

public class MainHospitalApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter a number.");
            return;
        }

        int numberOfPatients = scanner.nextInt();

        if (numberOfPatients <= 0) {
            System.out.println("Number of patients must be greater than 0.");
            return;
        }

        Patient[] patients = new Patient[numberOfPatients];
        int[] usedPatientIds = new int[numberOfPatients];
        String[] usedPatientNames = new String[numberOfPatients];
        int usedCount = 0;

        for (int i = 0; i < numberOfPatients; i++) {

            System.out.println("\nPatient " + (i + 1));
            System.out.println("1. In-Patient");
            System.out.println("2. Out-Patient");
            System.out.println("3. Emergency Patient");
            System.out.print("Choose patient type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice.");
                return;
            }

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Choose between 1 to 3 only.");
                return;
            }

            System.out.print("Enter Patient ID: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid patient ID.");
                return;
            }
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine().trim();

            if (!name.matches("[A-Za-z ]{2,}")) {
                System.out.println("Invalid name. Name must contain only alphabets and spaces (min 2 characters).");
                return;
            }
            boolean duplicateFound = false;
            boolean sameIdDifferentName = false;

            for (int j = 0; j < usedCount; j++) {
                if (usedPatientIds[j] == id && usedPatientNames[j].equalsIgnoreCase(name)) {
                    duplicateFound = true;
                    break;
                } else if (usedPatientIds[j] == id && !usedPatientNames[j].equalsIgnoreCase(name)) {
                    sameIdDifferentName = true;
                }
            }

            if (duplicateFound) {
                System.out.println("Duplicate patient found. Same Patient ID and Name already exist.");
                return;
            }

            if (sameIdDifferentName) {
                System.out.println("Patient ID already exists with a different name. Please verify patient details.");
                return;
            }

            usedPatientIds[usedCount] = id;
            usedPatientNames[usedCount] = name;
            usedCount++;

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Charges: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid room charges.");
                        return;
                    }
                    double roomCharges = scanner.nextDouble();
                    patients[i] = new InPatient(id, name, roomCharges);
                    break;

                case 2:
                    System.out.print("Enter Consultation Fee: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid consultation fee.");
                        return;
                    }
                    double consultationFee = scanner.nextDouble();
                    patients[i] = new OutPatient(id, name, consultationFee);
                    break;

                case 3:
                    System.out.print("Enter Emergency Surcharge: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid emergency surcharge.");
                        return;
                    }
                    double surcharge = scanner.nextDouble();
                    patients[i] = new EmergencyPatient(id, name, surcharge);
                    break;

                default:
                    System.out.println("Invalid patient type.");
                    return;
            }
        }

        System.out.println("\n--- Generating Bills ---");
        for (int i = 0; i < numberOfPatients; i++) {
            patients[i].generateBill();
            System.out.println();
            
        }
    }
}