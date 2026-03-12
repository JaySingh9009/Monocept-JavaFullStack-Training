package com.Arrayofobject.test;
import java.util.Scanner;
import com.Arrayofobject.model.*;

public class MainPayroll {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees to add :");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        int numberOfEmployee = scanner.nextInt();
        if (numberOfEmployee <= 0) {
            System.out.println("Number of employees must be greater than 0.");
            return;
        }

        Employee[] employees = new Employee[numberOfEmployee];
        int[] usedIds = new int[numberOfEmployee];
        int usedCount = 0;

        for (int i = 0; i < numberOfEmployee; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.println("1. Full Time Employee");
            System.out.println("2. Part Time Employee");
            System.out.println("3. Intern");
            System.out.print("Choose employee type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Must be a number.");
                return;
            }
            int choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid employee type selected.");
                return;
            }

            System.out.print("Enter Employee ID (integer): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Employee ID must be an integer.");
                return;
            }
            int empId = scanner.nextInt();

            if (empId <= 0) {
                System.out.println("Employee ID must be a positive number.");
                return;
            }

            for (int k = 0; k < usedCount; k++) {
                if (usedIds[k] == empId) {
                    System.out.println("Duplicate Employee ID not allowed.");
                    return;
                }
            }
            usedIds[usedCount++] = empId;

            scanner.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Employee name cannot be empty.");
                return;
            }
            switch (choice) {

                case 1:
                    System.out.print("Enter Base Salary: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Base salary must be numeric.");
                        return;
                    }
                    double baseSalary = scanner.nextDouble();
                    if (baseSalary <= 0) {
                        System.out.println("Base salary must be greater than 0.");
                        return;
                    }

                    System.out.print("Enter HRA: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("HRA must be numeric.");
                        return;
                    }
                    double hra = scanner.nextDouble();
                    if (hra < 0) {
                        System.out.println("HRA cannot be negative.");
                        return;
                    }

                    System.out.print("Enter DA: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("DA must be numeric.");
                        return;
                    }
                    double da = scanner.nextDouble();
                    if (da < 0) {
                        System.out.println("DA cannot be negative.");
                        return;
                    }

                    employees[i] = new FullTimeEmployee(empId, name, baseSalary, hra, da);
                    break;

                case 2:
                    System.out.print("Enter Hourly Rate: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Hourly rate must be numeric.");
                        return;
                    }
                    double hourlyRate = scanner.nextDouble();
                    if (hourlyRate <= 0) {
                        System.out.println("Hourly rate must be greater than 0.");
                        return;
                    }

                    System.out.print("Enter Hours Worked: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Hours worked must be an integer.");
                        return;
                    }
                    int hoursWorked = scanner.nextInt();
                    if (hoursWorked <= 0) {
                        System.out.println("Hours worked must be greater than 0.");
                        return;
                    }

                    employees[i] = new PartTimeEmployee(empId, name, hourlyRate, hoursWorked);
                    break;

                case 3:
                    System.out.print("Enter Stipend: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Stipend must be numeric.");
                        return;
                    }
                    double stipend = scanner.nextDouble();
                    if (stipend <= 0) {
                        System.out.println("Stipend must be greater than 0.");
                        return;
                    }

                    employees[i] = new Intern(empId, name, stipend);
                    break;
            }

            scanner.nextLine(); 
        }

        System.out.println("\n---- Employee Salaries ----");
        for (Employee e : employees) {
            System.out.println(
                "ID: " + e.getEmpId() +
                ", Name: " + e.getName() +
                ", Salary: ₹" + e.calculateSalary()
            );
        }

        System.out.println("\nTotal Employees Created: " + Employee.getTotalEmployees());
    }
}