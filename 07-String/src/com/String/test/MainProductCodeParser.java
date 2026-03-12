package com.String.test;



import java.util.Scanner;

import com.String.model.ProductCodeParser;

public class MainProductCodeParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Product Code: ");
            String code = sc.nextLine().trim();

         
            if (!code.contains("-")) {
                throw new IllegalArgumentException("Invalid product code format");
            }

            String[] parts = code.split("-");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Product code must be in CAT-ITEMCODE-YEAR format");
            }

            ProductCodeParser parser = new ProductCodeParser(code);

            System.out.println("Category: " + parser.getCategory());
            System.out.println("Product: " + parser.getProductName());
            System.out.println("Year: " + parser.getYear());

            System.out.println("Starts with TV: " + 
                    (parser.startsWithTV() ? "Yes" : "No"));

            System.out.println("Ends with 2023: " + 
                    (parser.endsWith2023() ? "Yes" : "No"));

            System.out.println("Modified Code: " + parser.getModifiedCode());

            System.out.println("First hyphen position: " + 
                    parser.getFirstHyphenPosition());

        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }
}
