package com.onlineOrderApp.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.onlineOrderApp.model.ExpressOrder;
import com.onlineOrderApp.model.InternationalOrder;
import com.onlineOrderApp.model.InvalidOrderException;
import com.onlineOrderApp.model.Order;
import com.onlineOrderApp.model.OrderVerification;
import com.onlineOrderApp.model.StandardOrder;


public class OrderServiceManager {

    Scanner sc = new Scanner(System.in);

    Order[] orders = new Order[100];
    int count = 0;

    public void startSystem() {

        while (true) {

            System.out.println("\n---- Online Order Fulfillment System ----");
            System.out.println("1. Add Order");
            System.out.println("2. Display Orders");
            System.out.println("3. Exit");

            int choice = getMenuChoice();

            switch (choice) {

            case 1:
                addOrder();
                break;

            case 2:
                displayOrders();
                break;

            case 3:
                System.out.println("System Closed");
                sc.close();
                return;
            }
        }
    }

    private int getMenuChoice() {

        while (true) {

            try {

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 3)
                    return choice;

                System.out.println("Invalid choice.");

            } catch (InputMismatchException e) {

                System.out.println("Enter numeric value.");
                sc.nextLine();
            }
        }
    }

    private void addOrder() {

        try {

            int type = getOrderType();

            int id = getOrderId();

            if (isDuplicateId(id)) {

                System.out.println("Duplicate Order ID!");
                return;
            }

            String name = getCustomerName();

            double amount = getOrderAmount();

            switch (type) {

            case 1:
                orders[count++] = new StandardOrder(id, name, amount);
                break;

            case 2:
                orders[count++] = new ExpressOrder(id, name, amount);
                break;

            case 3:
                orders[count++] = new InternationalOrder(id, name, amount);
                break;
            }

            System.out.println("Order Added Successfully");

        } catch (InvalidOrderException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean isDuplicateId(int id) {

        for (int i = 0; i < count; i++) {

            if (orders[i].orderId == id)
                return true;
        }

        return false;
    }

    private int getOrderType() {

        while (true) {

            try {

                System.out.println("Select Order Type");
                System.out.println("1. Standard Order");
                System.out.println("2. Express Order");
                System.out.println("3. International Order");

                int type = sc.nextInt();
                sc.nextLine();

                if (type >= 1 && type <= 3)
                    return type;

                System.out.println("Invalid type");

            } catch (InputMismatchException e) {

                System.out.println("Enter numeric value");
                sc.nextLine();
            }
        }
    }

    private int getOrderId() {

        while (true) {

            try {

                System.out.print("Enter Order ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                if (id > 0)
                    return id;

                System.out.println("Order ID must be positive");

            } catch (InputMismatchException e) {

                System.out.println("Invalid ID");
                sc.nextLine();
            }
        }
    }

    private String getCustomerName() {

        while (true) {

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine().trim();

            if (name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"))
                return name;

            System.out.println("Invalid name");
        }
    }

    private double getOrderAmount() {

        while (true) {

            try {

                System.out.print("Enter Order Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                if (amount > 0)
                    return amount;

                System.out.println("Amount must be greater than 0");

            } catch (InputMismatchException e) {

                System.out.println("Invalid number");
                sc.nextLine();
            }
        }
    }

    private void displayOrders() {

        if (count == 0) {

            System.out.println("No orders found.");
            return;
        }

        System.out.println("\n---- Order Records ----");

        for (int i = 0; i < count; i++) {

            Order order = orders[i];

            System.out.println("\nOrder ID: " + order.orderId);
            System.out.println("Customer: " + order.customerName);

            double total = order.processOrder();

            System.out.println("Processed Amount: " + total);

            OrderVerification v = (OrderVerification) order;

            if (v.verifyOrder())
                System.out.println("Order Verified");
            else
                System.out.println("Order Rejected");
        }
    }
}
