package com.comparableAndcomparator.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.comparableAndcomparator.model.Product;
import com.comparableAndcomparator.model.ProductComparator;

public class ProductMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        int n;

        while (true) {
            System.out.print("Enter number of products: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0)
                    break;
                else
                    System.out.println("Number must be positive.");
            } else {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {

            String category;

            while (true) {
                System.out.print("Enter category: ");
                category = sc.nextLine();

                if (!category.trim().isEmpty())
                    break;
                else
                    System.out.println("Category cannot be empty.");
            }

            String name;

            while (true) {
                System.out.print("Enter product name: ");
                name = sc.nextLine();

                if (!name.trim().isEmpty())
                    break;
                else
                    System.out.println("Name cannot be empty.");
            }

            double price;

            while (true) {
                System.out.print("Enter price: ");

                if (sc.hasNextDouble()) {
                    price = sc.nextDouble();
                    sc.nextLine();

                    if (price >= 0)
                        break;
                    else
                        System.out.println("Price cannot be negative.");
                } else {
                    System.out.println("Invalid price.");
                    sc.nextLine();
                }
            }

            list.add(new Product(category, name, price));
        }

        Collections.sort(list, new ProductComparator());

        System.out.println("\nSorted Products:");

        for (Product p : list) {
            System.out.println(p);
        }

        sc.close();
    }
}
