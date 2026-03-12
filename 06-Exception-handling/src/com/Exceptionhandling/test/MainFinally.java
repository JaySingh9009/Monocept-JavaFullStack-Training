package com.Exceptionhandling.test;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Exceptionhandling.model.ATMLogic;

public class MainFinally {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATMLogic atm = new ATMLogic();

        try {

            System.out.println("===== ATM Withdrawal System =====");
       

            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            double newBalance = atm.withdraw(amount);

            System.out.println("Withdrawal successful!");
            System.out.println("Remaining Balance: " + newBalance);

        } 
        catch (ArithmeticException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric value.");
        } 
        finally {
            System.out.println("Transaction session ended.");
            scanner.close();
        }
    }
}