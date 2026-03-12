package com.hospitalsystem.test;

import java.util.Scanner;
import com.hospitalsystem.model.*;

public class MainHospitalSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of staff records: ");
        int n = sc.nextInt();
        sc.nextLine();

        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for staff " + (i + 1));

            int id;
            boolean duplicate;

            do {
                duplicate = false;

                System.out.print("Staff ID: ");
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("ID must be positive");
                    duplicate = true;
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    if (staffList[j].getId() == id) {
                        System.out.println("Duplicate ID not allowed");
                        duplicate = true;
                        break;
                    }
                }

            } while (duplicate);


            String name;

            do {
                System.out.print("Name: ");
                name = sc.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty");
                }
                else if (!name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                    System.out.println("Name must contain only letters and single spaces");
                }

            } while (name.isEmpty() || !name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));


            String department;

            do {
                System.out.print("Department: ");
                department = sc.nextLine().trim();

                if (department.isEmpty()) {
                    System.out.println("Department cannot be empty");
                }
                else if (!department.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                    System.out.println("Department must contain only letters and single spaces");
                }

            } while (department.isEmpty() || !department.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));


            System.out.println("Choose Staff Type");
            System.out.println("1. Doctor");
            System.out.println("2. Nurse");

            int type = sc.nextInt();
            sc.nextLine();

            try {

                if (type == 1) {

                
                    String specialization;

                    do {
                        System.out.print("Specialization: ");
                        specialization = sc.nextLine().trim();

                        if (specialization.isEmpty()) {
                            System.out.println("Specialization cannot be empty");
                        }
                        else if (!specialization.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                            System.out.println("Only letters and single spaces allowed");
                        }

                    } while (specialization.isEmpty() || !specialization.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));

                    staffList[i] = new Doctor(id, name, department, specialization);
                }

                else if (type == 2) {

                    String shift;

                    do {
                        System.out.print("Shift (Day/Night): ");
                        shift = sc.nextLine().trim();

                        if (!(shift.equalsIgnoreCase("Day") || shift.equalsIgnoreCase("Night"))) {
                            System.out.println("Shift must be Day or Night");
                        }

                    } while (!(shift.equalsIgnoreCase("Day") || shift.equalsIgnoreCase("Night")));

                    staffList[i] = new Nurse(id, name, department, shift);
                }

                else {
                    System.out.println("Invalid choice. Try again.");
                    i--;
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

      

        System.out.println("\n------ Hospital Staff Records ------");

        for (Staff s : staffList) {
            s.displayDetails(); 
        }

        sc.close();
    }
}