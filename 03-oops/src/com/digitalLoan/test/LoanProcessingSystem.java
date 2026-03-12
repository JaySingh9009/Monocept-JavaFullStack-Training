package com.digitalLoan.test;

import java.util.Scanner;

import com.digitalLoan.model.CarLoan;
import com.digitalLoan.model.EducationLoan;
import com.digitalLoan.model.HomeLoan;
import com.digitalLoan.model.InvalidLoanException;
import com.digitalLoan.model.Loan;
import com.digitalLoan.model.LoanEligibility;

public class LoanProcessingSystem {

    public static boolean isDuplicateLoanId(Loan[] loans, String id) {
        for (Loan loan : loans) {
            if (loan != null && loan.loanId.equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidName(String name) {
        return name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of loans: ");
        int n = sc.nextInt();
        sc.nextLine();

        Loan[] loans = new Loan[n];
        double[] incomes = new double[n];

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("\nEnter Loan Details " + (i + 1));

                int choice;
                while (true) {
                    System.out.println("Select Loan Type:");
                    System.out.println("1. Home Loan");
                    System.out.println("2. Car Loan");
                    System.out.println("3. Education Loan");

                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice! Please select 1, 2, or 3.");
                    }
                }

                String id;
                while (true) {
                    System.out.print("Enter Loan ID: ");
                    id = sc.nextLine().trim();

                    if (id.isEmpty()) {
                        System.out.println("Loan ID cannot be empty.");
                    } else if (isDuplicateLoanId(loans, id)) {
                        System.out.println("Duplicate Loan ID! Enter a unique Loan ID.");
                    } else {
                        break;
                    }
                }

                String name;
                while (true) {
                    System.out.print("Enter Borrower Name: ");
                    name = sc.nextLine().trim();

                    if (isValidName(name)) {
                        break;
                    } else {
                        System.out.println("Invalid name! Only alphabets with single spaces allowed.");
                    }
                }

                System.out.print("Enter Principal Amount: ");
                double principal = sc.nextDouble();

                System.out.print("Enter Interest Rate: ");
                double rate = sc.nextDouble();

                System.out.print("Enter Borrower's Monthly Income: ");
                incomes[i] = sc.nextDouble();
                sc.nextLine();

                if (incomes[i] <= 0) {
                    System.out.println("Income must be greater than 0. Re-enter this loan.");
                    i--;
                    continue;
                }

                switch (choice) {
                    case 1:
                        loans[i] = new HomeLoan(id, name, principal, rate);
                        break;

                    case 2:
                        loans[i] = new CarLoan(id, name, principal, rate);
                        break;

                    case 3:
                        loans[i] = new EducationLoan(id, name, principal, rate);
                        break;
                }

            } catch (InvalidLoanException e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n------ Loan Processing ------");

        for (int i = 0; i < loans.length; i++) {
            Loan loan = loans[i];

            System.out.println("\nLoan ID: " + loan.loanId);
            System.out.println("Borrower: " + loan.borrowerName);

            double repayment = loan.calculateRepayment();
            System.out.println("Total Repayment: " + repayment);

            if (loan instanceof LoanEligibility) {
                LoanEligibility eligibility = (LoanEligibility) loan;

                if (eligibility.checkEligibility(incomes[i])) {
                    System.out.println("Loan Eligible");
                } else {
                    System.out.println("Loan Not Eligible");
                }
            }
        }

        sc.close();
    }
}