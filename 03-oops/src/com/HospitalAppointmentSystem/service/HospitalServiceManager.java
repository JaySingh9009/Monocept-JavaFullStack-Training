package com.HospitalAppointmentSystem.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.HospitalAppointmentSystem.model.*;

public class HospitalServiceManager {

    Scanner sc = new Scanner(System.in);

    private HospitalService[] services = new HospitalService[100];
    private int count = 0;

    public void startSystem() {

        while (true) {

            System.out.println("\n------ Hospital Appointment System ------");
            System.out.println("1. Add Patient Service");
            System.out.println("2. Display Services");
            System.out.println("3. Exit");

            int choice = getMenuChoice();

            switch (choice) {

            case 1:
                addService();
                break;

            case 2:
                displayServices();
                break;

            case 3:
                System.out.println("System Closed");
                sc.close();
                return;

            }
        }
    }



    private int getMenuChoice() {

        while (true) {

            try {

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 3)
                    return choice;

                System.out.println("Invalid choice. Enter 1-3.");

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Enter numeric value.");
                sc.nextLine();
            }
        }
    }



    private void addService() {

        try {

            int serviceType = getServiceChoice();

            int id = getServiceId();

            if (isDuplicateId(id)) {

                System.out.println("Duplicate Service ID! Cannot add.");
                return;
            }

            String name = getPatientName();

            double fee = getConsultationFee();

            switch (serviceType) {

            case 1:
                services[count++] = new GeneralConsultation(id, name, fee);
                break;

            case 2:
                services[count++] = new Surgery(id, name, fee);
                break;

            case 3:
                services[count++] = new DiagnosticTest(id, name, fee);
                break;
            }

            System.out.println("Service Added Successfully.");

        } catch (InvalidServiceException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------- DUPLICATE ID CHECK --------

    private boolean isDuplicateId(int id) {

        for (int i = 0; i < count; i++) {

            if (services[i].serviceId == id)
                return true;
        }

        return false;
    }



    private int getServiceChoice() {

        while (true) {

            try {

                System.out.println("Select Service Type:");
                System.out.println("1. General Consultation");
                System.out.println("2. Surgery");
                System.out.println("3. Diagnostic Test");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 3)
                    return choice;

                System.out.println("Invalid service choice.");

            } catch (InputMismatchException e) {

                System.out.println("Enter numeric value.");
                sc.nextLine();
            }
        }
    }


    private int getServiceId() {

        while (true) {

            try {

                System.out.print("Enter Service ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                if (id > 0)
                    return id;

                System.out.println("Service ID must be positive.");

            } catch (InputMismatchException e) {

                System.out.println("Invalid ID! Enter numeric value.");
                sc.nextLine();
            }
        }
    }

    // -------- PATIENT NAME --------

    private String getPatientName() {

        while (true) {

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine().trim();

            if (name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"))
                return name;

            System.out.println("Invalid name! Only alphabets allowed.");
        }
    }

   

    private double getConsultationFee() {

        while (true) {

            try {

                System.out.print("Enter Consultation Fee: ");
                double fee = sc.nextDouble();
                sc.nextLine();

                if (fee > 0)
                    return fee;

                System.out.println("Fee must be greater than 0.");

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Enter numeric value.");
                sc.nextLine();
            }
        }
    }



    private void displayServices() {

        if (count == 0) {

            System.out.println("No services available.");
            return;
        }

        System.out.println("\n------ Service Records ------");

        for (int i = 0; i < count; i++) {

            HospitalService service = services[i];

            System.out.println("\nService ID: " + service.serviceId);
            System.out.println("Patient Name: " + service.patientName);

            double total = service.calculateTotalCost();

            System.out.println("Total Cost: " + total);

            ServiceValidation validation = (ServiceValidation) service;

            if (validation.validateService())
                System.out.println("Service Approved");
            else
                System.out.println("Service Not Approved");
        }
    }
}