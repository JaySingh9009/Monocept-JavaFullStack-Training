package com.String.test;

import java.util.Scanner;

import com.String.model.IpValidator;

public class MainIpValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter IP address: ");
            String ip = sc.nextLine();

            if (ip == null || ip.trim().isEmpty()) {
                throw new IllegalArgumentException("IP cannot be empty");
            }

            IpValidator validator = new IpValidator();

            if (validator.isValid(ip))
                System.out.println("Valid IPv4 Address");
            else
                System.out.println("Invalid IPv4 Address");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
