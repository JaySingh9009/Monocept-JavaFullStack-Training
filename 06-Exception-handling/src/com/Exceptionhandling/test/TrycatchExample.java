package com.Exceptionhandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Exceptionhandling.model.DivisionLogic;

public class TrycatchExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DivisionLogic logic = new DivisionLogic();

       

        while (true) {

            try {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();

                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();

                int result = logic.divide(num1, num2);

                System.out.println("Result = " + result);

            } 
            catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero.");
            } 
            catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid numeric values only.");
                scanner.nextLine(); 
            } 

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
               break;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}