package com.constructor.test;


import java.util.Scanner;
import com.constructor.model.*;


public class MainProductAndOrdder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create Product ===");

        System.out.print("Enter Product ID (positive integer): ");
        int productId;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer Product ID:");
            scanner.next();
        }
        productId = scanner.nextInt();

        if (productId <= 0) {
            System.out.println("Product ID must be positive. Exiting application.");
            scanner.close();
            return;
        }

        System.out.print("Enter Product Price (> 0): ");
        double productPrice;
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid price:");
            scanner.next();
        }
        productPrice = scanner.nextDouble();

        if (productPrice <= 0) {
            System.out.println("Product price must be greater than 0. Exiting application.");
            scanner.close();
            return;
        }

        System.out.print("Enter Stock Quantity: ");
        int stockQuantity;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer stock quantity:");
            scanner.next();
        }
        stockQuantity = scanner.nextInt();

        Product product = new Product(productId, productPrice, stockQuantity);
        System.out.println("Product created successfully!");
        
        System.out.println("\n=== Create Order ===");
        System.out.println("Choose Order Type:");
        System.out.println("1. Normal Order");
        System.out.println("2. Discounted Order");

        int orderTypeChoice;
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid option (1 or 2):");
            scanner.next();
        }
        orderTypeChoice = scanner.nextInt();

        if (orderTypeChoice != 1 && orderTypeChoice != 2) {
            System.out.println("Invalid order type choice. Exiting application.");
            scanner.close();
            return;
        }

        System.out.print("Enter Order Quantity (> 0): ");
        int orderQuantity;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer quantity:");
            scanner.next();
        }
        orderQuantity = scanner.nextInt();

        if (orderQuantity <= 0) {
            System.out.println("Order quantity must be greater than 0. Exiting application.");
            scanner.close();
            return;
        }
        if (orderTypeChoice == 1) {
            Order order = new Order(product, orderQuantity);
            System.out.println("Normal Order created successfully!");
            System.out.println("Total Amount: " + order.getTotalAmount());

        } else {
            System.out.print("Enter Discount Percentage (0–100): ");
            double discountPercentage;
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid discount percentage:");
                scanner.next();
            }
            discountPercentage = scanner.nextDouble();

            if (discountPercentage < 0 || discountPercentage > 100) {
                System.out.println("Discount percentage must be between 0 and 100. Exiting application.");
                scanner.close();
                return;
            }

            DiscountedOrder discountedOrder = new DiscountedOrder(product, orderQuantity, discountPercentage);
            System.out.println("Discounted Order created successfully!");
            System.out.println("Discounted Total Amount:" + discountedOrder.getTotalAmount());
        }

        scanner.close();
    }
}
