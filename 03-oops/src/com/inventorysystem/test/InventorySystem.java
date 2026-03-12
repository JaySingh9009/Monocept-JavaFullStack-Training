package com.inventorysystem.test;

import java.util.Scanner;
import com.inventorysystem.model.*;

public class InventorySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter details for product " + (i+1));

            int id;
            boolean duplicate;

            do {

                duplicate = false;

                System.out.print("Product ID: ");
                id = sc.nextInt();
                sc.nextLine();

                if(id <= 0) {
                    System.out.println("Invalid ID");
                    duplicate = true;
                    continue;
                }

                for(int j = 0; j < i; j++) {

                    if(products[j].getProductId() == id) {
                        System.out.println("Duplicate Product ID");
                        duplicate = true;
                        break;
                    }
                }

            } while(duplicate);

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Base Price: ");
            double price = sc.nextDouble();

            System.out.println("Choose Product Category");
            System.out.println("1. Electronics");
            System.out.println("2. Clothing");

            int type = sc.nextInt();
            sc.nextLine();

            try {

                if(type == 1) {

                    System.out.print("Brand: ");
                    String brand = sc.nextLine();

                    products[i] = new Electronics(id, name, price, brand);
                }

                else if(type == 2) {

                    System.out.print("Size: ");
                    String size = sc.nextLine();

                    products[i] = new Clothing(id, name, price, size);
                }

                else {

                    System.out.println("Invalid category");
                    i--;
                }

            } catch(Exception e) {

                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n------ Product Inventory ------");

        for(Product p : products) {
            p.displayDetails(); 
        }

        sc.close();
    }
}
