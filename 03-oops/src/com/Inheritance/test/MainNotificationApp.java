package com.Inheritance.test;
import com.Inheritance.model.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainNotificationApp {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Choose Notification Type:");
        System.out.println("1. Email Notification");
        System.out.println("2. SMS Notification");
        System.out.println("3. Push Notification");

        int notificationTypeChoice = inputScanner.nextInt();
        inputScanner.nextLine(); 

        String recipient;

        if (notificationTypeChoice == 1) {
     
            while (true) {
                System.out.print("Enter email address: ");
                recipient = inputScanner.nextLine();

                if (isValidEmail(recipient)) {
                    break;
                } else {
                    System.out.println("Invalid email format. Try again.");
                }
            }
        } 
        else if (notificationTypeChoice == 2) {
           
            while (true) {
                System.out.print("Enter 10-digit mobile number: ");
                recipient = inputScanner.nextLine();

                if (isValidPhoneNumber(recipient)) {
                    break;
                } else {
                    System.out.println("Invalid mobile number. Enter exactly 10 digits.");
                }
            }
        } 
        else if (notificationTypeChoice == 3) {
  
            System.out.print("Enter recipient (username/deviceId): ");
            recipient = inputScanner.nextLine();
        } 
        else {
            System.out.println("Invalid choice. Exiting application.");
            inputScanner.close();
            return;
        }

        System.out.print("Enter message: ");
        String message = inputScanner.nextLine();

        Notification notification;

        if (notificationTypeChoice == 1) {
            notification = new EmailNotification(recipient, message);
        } 
        else if (notificationTypeChoice == 2) {
            notification = new SMSNotification(recipient, message);
        } 
        else {
            notification = new PushNotification(recipient, message);
        }

        System.out.println("\n--- Sending Notification ---");
        notification.send();

        inputScanner.close();
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

   
    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }
}