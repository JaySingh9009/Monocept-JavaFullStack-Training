package com.Inheritance.test;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import com.Inheritance.model.*;



public class PayrollApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int numberOfEmployees = scanner.nextInt();

        Employee[] employees = new Employee[numberOfEmployees];
        Set<Integer> usedEmployeeIds = new HashSet<>();  
        for (int index = 0; index < numberOfEmployees; index++) {

            System.out.println("\nEnter details for Employee " + (index + 1));
            System.out.println("Choose Employee Type:");
            System.out.println("1. Full Time Employee");
            System.out.println("2. Part Time Employee");
            System.out.println("3. Contract Employee");

            int employeeTypeChoice = scanner.nextInt();

            int employeeId;
            while (true) {
                System.out.print("Enter Employee ID (must be unique): ");
                employeeId = scanner.nextInt();

                if (usedEmployeeIds.contains(employeeId)) {
                    System.out.println("This Employee ID already exists. Please enter a different ID.");
                } else {
                    usedEmployeeIds.add(employeeId);
                    break;
                }
            }

            scanner.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String employeeName = scanner.nextLine();

            if (employeeTypeChoice == 1) {
                System.out.print("Enter Basic Salary: ");
                double basicSalary = scanner.nextDouble();

                System.out.print("Enter HRA: ");
                double houseRentAllowance = scanner.nextDouble();

                System.out.print("Enter DA: ");
                double dearnessAllowance = scanner.nextDouble();

                employees[index] = new FullTimeEmployee(
                        employeeId, employeeName, basicSalary, houseRentAllowance, dearnessAllowance
                );

            } else if (employeeTypeChoice == 2) {
                System.out.print("Enter Hours Worked: ");
                int hoursWorked = scanner.nextInt();

                System.out.print("Enter Hourly Rate: ");
                double hourlyRate = scanner.nextDouble();

                employees[index] = new PartTimeEmployee(
                        employeeId, employeeName, hoursWorked, hourlyRate
                );

            } else if (employeeTypeChoice == 3) {
                System.out.print("Enter Fixed Amount: ");
                double fixedAmount = scanner.nextDouble();

                System.out.print("Enter Tax: ");
                double tax = scanner.nextDouble();

                employees[index] = new ContractEmployee(
                        employeeId, employeeName, fixedAmount, tax
                );

            } else {
                System.out.println("Invalid employee type. Try again.");
                index--; 
            }
        }

        System.out.println("\nPAYSLIP ");

        for (Employee employee : employees) {
            employee.displayEmployee();
            double salary = employee.calculateSalary();   
            System.out.println("Calculated Salary: ₹" + salary);
           
        }

        scanner.close();
    }
}