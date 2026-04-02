package com.digitalLoan.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.digitalLoan.model.CarLoan;
import com.digitalLoan.model.EducationLoan;
import com.digitalLoan.model.HomeLoan;
import com.digitalLoan.model.InvalidLoanException;
import com.digitalLoan.model.Loan;
import com.digitalLoan.model.LoanEligibility;

public class LoanServiceManager {

    Scanner sc = new Scanner(System.in);

    Loan[] loans = new Loan[100];
    double[] incomes = new double[100];

    int count = 0;

    public void startSystem() {

        while (true) {

            System.out.println("\n----- Digital Loan System -----");
            System.out.println("1. Add Loan");
            System.out.println("2. Display Loans");
            System.out.println("3. Exit");

            int choice = getMenuChoice();

            switch (choice) {

                case 1:
                    addLoan();
                    break;

                case 2:
                    displayLoans();
                    break;

                case 3:
                    System.out.println("System Closed");
                    sc.close();
                    return;
            }
        }
    }

    // -------- MENU VALIDATION --------

    private int getMenuChoice() {

        while (true) {

            try {

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 3)
                    return choice;

                System.out.println("Invalid choice.");

            } catch (InputMismatchException e) {

                System.out.println("Enter numeric value.");
                sc.nextLine();
            }
        }
    }

    // -------- ADD LOAN --------

    private void addLoan() {

        try {

            int type = getLoanType();

            int id = getLoanId();

            if (isDuplicateId(id)) {

                System.out.println("Duplicate Loan ID!");
                return;
            }

            String name = getBorrowerName();

            double principal = getPrincipal();

            double rate = getInterestRate();

            double income = getIncome();

            switch (type) {

                case 1:
                    loans[count] = new HomeLoan(id, name, principal, rate);
                    break;

                case 2:
                    loans[count] = new CarLoan(id, name, principal, rate);
                    break;

                case 3:
                    loans[count] = new EducationLoan(id, name, principal, rate);
                    break;
            }

            incomes[count] = income;
            count++;

            System.out.println("Loan Added Successfully");

        } catch (InvalidLoanException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // -------- DUPLICATE ID CHECK --------

    private boolean isDuplicateId(int id) {

        for (int i = 0; i < count; i++) {

            if (loans[i].loanId == id)
                return true;
        }

        return false;
    }

    // -------- LOAN TYPE --------

    private int getLoanType() {

        while (true) {

            try {

                System.out.println("Select Loan Type");
                System.out.println("1. Home Loan");
                System.out.println("2. Car Loan");
                System.out.println("3. Education Loan");

                int type = sc.nextInt();
                sc.nextLine();

                if (type >= 1 && type <= 3)
                    return type;

                System.out.println("Invalid type");

            } catch (InputMismatchException e) {

                System.out.println("Enter numeric value");
                sc.nextLine();
            }
        }
    }

    // -------- LOAN ID --------

    private int getLoanId() {

        while (true) {

            try {

                System.out.print("Enter Loan ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                if (id > 0)
                    return id;

                System.out.println("Loan ID must be positive");

            } catch (InputMismatchException e) {

                System.out.println("Invalid ID");
                sc.nextLine();
            }
        }
    }

    // -------- NAME --------

    private String getBorrowerName() {

        while (true) {

            System.out.print("Enter Borrower Name: ");
            String name = sc.nextLine().trim();

            if (name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"))
                return name;

            System.out.println("Invalid name");
        }
    }

    // -------- PRINCIPAL --------

    private double getPrincipal() {

        while (true) {

            try {

                System.out.print("Enter Principal Amount: ");
                double p = sc.nextDouble();

                if (p > 0)
                    return p;

                System.out.println("Principal must be >0");

            } catch (InputMismatchException e) {

                System.out.println("Invalid number");
                sc.nextLine();
            }
        }
    }

    // -------- INTEREST RATE --------

    private double getInterestRate() {

        while (true) {

            try {

                System.out.print("Enter Interest Rate (0-100): ");
                double r = sc.nextDouble();

                if (r > 0 && r <= 100)
                    return r;

                System.out.println("Rate must be between 0 and 100");

            } catch (InputMismatchException e) {

                System.out.println("Invalid number");
                sc.nextLine();
            }
        }
    }

    // -------- INCOME --------

    private double getIncome() {

        while (true) {

            try {

                System.out.print("Enter Borrower Income: ");
                double income = sc.nextDouble();
                sc.nextLine();

                if (income > 0)
                    return income;

                System.out.println("Income must be >0");

            } catch (InputMismatchException e) {

                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
    }

    // -------- DISPLAY --------

    private void displayLoans() {

        if (count == 0) {

            System.out.println("No loan records found.");
            return;
        }

        System.out.println("\n----- Loan Records -----");

        for (int i = 0; i < count; i++) {

            Loan loan = loans[i];

            System.out.println("\nLoan ID: " + loan.loanId);
            System.out.println("Borrower: " + loan.borrowerName);

            double repay = loan.calculateRepayment();

            System.out.println("Repayment Amount: " + repay);

            LoanEligibility el = (LoanEligibility) loan;

            if (el.checkEligibility(incomes[i]))
                System.out.println("Eligible");
            else
                System.out.println("Not Eligible");
        }
    }
}
