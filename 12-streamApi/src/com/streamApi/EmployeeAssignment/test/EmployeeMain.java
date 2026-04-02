package com.streamApi.EmployeeAssignment.test;
import com.streamApi.EmployeeAssignment.model.EmployeeController;
import java.util.*;

public class EmployeeMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeController controller = new EmployeeController();

        int choice;

        do {
        	System.out.println("\n===== Employee Management System =====");
        	System.out.println("1. Add Employee");
        	System.out.println("2. View Active Employees");
        	System.out.println("3. Employees with High Salary");
        	System.out.println("4. Count Employees by Department");
        	System.out.println("5. Highest Paid Employee");
        	System.out.println("6. Names Sorted by Salary");
        	System.out.println("7. Group Employees by Department");
        	System.out.println("8. Average Salary by Department");
        	System.out.println("9. Exit");
        	System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.addEmployee();
                    break;

                case 2:
                    controller.showActive();
                    break;

                case 3:
                    controller.highSalary();
                    break;

                case 4:
                    controller.countDept();
                    break;

                case 5:
                    controller.highestPaid();
                    break;

                case 6:
                    controller.sortedNames();
                    break;

                case 7:
                    controller.groupDept();
                    break;

                case 8:
                    controller.avgSalary();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }
}