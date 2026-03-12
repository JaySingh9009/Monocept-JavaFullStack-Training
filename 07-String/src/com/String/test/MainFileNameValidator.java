package com.String.test;

import java.util.Scanner;

import com.String.model.FileNameValidator;

public class MainFileNameValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter File Name: ");
            String file = sc.nextLine();

            if (file == null || file.trim().isEmpty()) {
                throw new IllegalArgumentException("File name cannot be empty");
            }

            if (!file.contains(".")) {
                throw new IllegalArgumentException("Invalid file format. Extension missing.");
            }

            FileNameValidator validator = new FileNameValidator(file);

            System.out.println("File Name: " + validator.getUpperCaseName());
            System.out.println("Extension: " + validator.getExtension());

            System.out.println("Is PDF file: " +
                    (validator.isPdf() ? "Yes" : "No"));

            System.out.println("Contains 'final': " +
                    (validator.containsFinal() ? "Yes" : "No"));

        }

        catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

        finally {
            sc.close();
        }
    }
}