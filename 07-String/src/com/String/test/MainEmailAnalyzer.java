package com.String.test;

import java.util.Scanner;

import com.String.model.EmailAnalyzer;

public class MainEmailAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            email = email.trim();

            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid Email: '@' symbol missing");
            }

            EmailAnalyzer analyzer = new EmailAnalyzer(email);

            String username = analyzer.getUsername();
            String domain = analyzer.getDomain();

            System.out.println("Username: " + username);
            System.out.println("Domain: " + domain);
            System.out.println("Total characters in username: " + analyzer.getUsernameLength());

            System.out.println("Contains digits: " +  (analyzer.hasDigitsInUsername() ? "Yes" : "No"));

            System.out.println("Modified username: " + analyzer.getModifiedUsername());

            if (analyzer.isGmail()) {
                System.out.println("This email belongs to Gmail");
            }

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}