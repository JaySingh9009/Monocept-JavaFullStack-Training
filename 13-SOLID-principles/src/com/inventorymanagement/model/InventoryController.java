package com.inventorymanagement.model;

import java.util.*;

public class InventoryController {

    private Scanner sc = new Scanner(System.in);
    private InventoryService service;

    public void start() {

        List<Notifier> notifiers = Arrays.asList(
                new EmailNotifier(),
                new SMSNotifier()
        );

        ReorderService reorderService = new ReorderService();
        service = new InventoryService(notifiers, reorderService);

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: removeStock(); break;
                case 3: service.showInventory(); break;
                case 4: updateProduct(); break;
                case 5: deleteProduct(); break;
                case 6: System.out.println("Exiting..."); return;
            }
        }
    }

    private void showMenu() {
    	System.out.println("==========Inventory Management System==========");
        System.out.println("\n1. Add Product");
        System.out.println("2. Remove Stock");
        System.out.println("3. Show Inventory");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Exit");
    }

    private int getChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.next());
                if (choice < 1 || choice > 6)
                    throw new IllegalArgumentException();
                return choice;
            } catch (Exception e) {
                System.out.println("Enter valid choice (1-6)");
            }
        }
    }

    private void addProduct() {
        try {
            System.out.print("Name: ");
            String name = sc.next();

            if (!name.matches("[a-zA-Z]+"))
                throw new IllegalArgumentException("Invalid name!");

            System.out.print("Quantity: ");
            int qty = Integer.parseInt(sc.next());

            System.out.print("Price: ");
            double price = Double.parseDouble(sc.next());

            System.out.print("Reorder Level: ");
            int reorder = Integer.parseInt(sc.next());

            if (qty <= 0 || price <= 0)
                throw new IllegalArgumentException("Invalid values!");

            service.addProduct(new Product(name, qty, price, reorder));

        } catch (DuplicateProductException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    private void updateProduct() {
        try {
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("New Quantity: ");
            int qty = Integer.parseInt(sc.next());

            System.out.print("New Price: ");
            double price = Double.parseDouble(sc.next());

            System.out.print("New Reorder Level: ");
            int reorder = Integer.parseInt(sc.next());

            if (qty <= 0 || price <= 0)
                throw new IllegalArgumentException("Invalid values!");

            service.updateProduct(name, qty, price, reorder);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProduct() {
        System.out.print("Name: ");
        String name = sc.next();
        service.deleteProduct(name);
    }

    private void removeStock() {
        try {
            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Quantity: ");
            int qty = Integer.parseInt(sc.next());

            if (qty <= 0)
                throw new IllegalArgumentException("Invalid quantity!");

            service.removeStock(name, qty);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}