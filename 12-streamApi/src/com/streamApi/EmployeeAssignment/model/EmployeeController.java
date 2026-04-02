package com.streamApi.EmployeeAssignment.model;

import java.util.*;

public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private EmployeeService service = new EmployeeService();

    public void addEmployee() {
        try {
            int id = validateId();
            String name = validateName();
            String dept = validateDepartment();
            double salary = validateSalary();
            int exp = validateExperience();
            boolean status = getBoolean("Is Active (true/false): ");

            employees.add(new Employee(id, name, dept, salary, exp, status));
            System.out.println("Employee Added!");

        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }
    }

    public void showActive() {
        display(service.getActiveEmployees(employees));
    }

    public void highSalary() {
        double threshold = getDouble("Enter threshold: ");
        display(service.getHighSalaryEmployees(employees, threshold));
    }

    public void countDept() {
        System.out.println(service.countByDepartment(employees));
    }

    public void highestPaid() {
        System.out.println(service.getHighestPaidEmployee(employees));
    }

    public void sortedNames() {
        System.out.println(service.getNamesSortedBySalary(employees));
    }

    public void groupDept() {
        System.out.println(service.groupByDepartment(employees));
    }

    public void avgSalary() {
        System.out.println(service.averageSalaryByDepartment(employees));
    }


    private int validateId() throws Exception {
        int id = getInt("Enter ID: ");

        if (id <= 0) throw new InvalidInputException("ID must be positive!");

        boolean exists = employees.stream()
                .anyMatch(e -> e.getEmployeeId() == id);

        if (exists) throw new DuplicateIdException("Duplicate ID!");

        return id;
    }

    private String validateName() throws Exception {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty() || !name.matches("[a-zA-Z ]+"))
            throw new InvalidInputException("Invalid Name!");

        return name;
    }

    private String validateDepartment() throws Exception {
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        if (dept.trim().isEmpty())
            throw new InvalidInputException("Department cannot be empty!");

        if (!dept.matches("[a-zA-Z ]+"))
            throw new InvalidInputException("Department must contain only letters!");

        return dept;
    }

    private double validateSalary() throws Exception {
        double salary = getDouble("Enter Salary: ");

        if (salary <= 0)
            throw new InvalidInputException("Salary must be positive!");

        return salary;
    }

    private int validateExperience() throws Exception {
        int exp = getInt("Enter Experience: ");

        if (exp < 0)
            throw new InvalidInputException("Invalid Experience!");

        return exp;
    }

   
    private void display(List<Employee> list) {
        if (list.isEmpty()) System.out.println("No Data!");
        else list.forEach(System.out::println);
    }

    private int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number!");
            }
        }
    }

    private double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid decimal!");
            }
        }
    }

    private boolean getBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().toLowerCase();

            if (input.equals("true") || input.equals("false"))
                return Boolean.parseBoolean(input);

            System.out.println("Enter true/false only!");
        }
    }
}