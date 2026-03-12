package com.encapsulation.test;

import java.util.Scanner;
import com.encapsulation.model.Product;

public class MainProduct {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine().trim();
        while (productId.isEmpty()) {
            System.out.println("Product ID cannot be empty. Try again:");
            productId = scanner.nextLine().trim();
        }

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine().trim();
        while (productName.isEmpty()) {
            System.out.println("Product name cannot be empty. Try again:");
            productName = scanner.nextLine().trim();
        }

        double price;
        while (true) {
            System.out.print("Enter Price: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price >= 0) break;
                System.out.println("Price cannot be negative.");
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }

        int stock;
        while (true) {
            System.out.print("Enter Initial Stock: ");
            if (scanner.hasNextInt()) {
                stock = scanner.nextInt();
                if (stock >= 0) break;
                System.out.println("Stock cannot be negative.");
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
        }

        Product product = new Product(productId, productName, price, stock);

        if (!product.isValidProduct()) {
            System.out.println("Product creation failed. Exiting...");
            scanner.close();
            return;
        }

        System.out.println("\nProduct created successfully!");
        System.out.println("ID: " + product.getProductId());
        System.out.println("Name: " + product.getProductName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Stock: " + product.getStockQuantity());
        System.out.println("Discontinued: " + product.isDiscontinued());

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Increase Stock (Restock)");
            System.out.println("2. Reduce Stock (Place Order)");
            System.out.println("3. Update Price (Admin)");
            System.out.println("4. Discontinue Product");
            System.out.println("5. View Product Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Enter a valid option (1–6):");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity to add: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid integer:");
                        scanner.next();
                    }
                    int addQty = scanner.nextInt();
                    product.increaseStock(addQty);
                    System.out.println("Updated Stock: " + product.getStockQuantity());
                    break;

                case 2:
                    System.out.print("Enter quantity to reduce (order): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Enter a valid integer:");
                        scanner.next();
                    }
                    int reduceQty = scanner.nextInt();
                    product.reduceStock(reduceQty);
                    System.out.println("Updated Stock: " + product.getStockQuantity());
                    break;

                case 3:
                    System.out.print("Enter new price: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Enter a valid price:");
                        scanner.next();
                    }
                    double newPrice = scanner.nextDouble();
                    product.updatePrice(newPrice);
                    System.out.println("Updated Price: " + product.getPrice());
                    break;

                case 4:
                    product.discontinueProduct();
                    break;

                case 5:
                    System.out.println("\n--- Product Details ---");
                    System.out.println("ID: " + product.getProductId());
                    System.out.println("Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Stock: " + product.getStockQuantity());
                    System.out.println("Discontinued: " + product.isDiscontinued());
                    break;

                case 6:
                    System.out.println("Goodbye 👋");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
