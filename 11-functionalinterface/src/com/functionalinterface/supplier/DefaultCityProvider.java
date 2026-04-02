package com.functionalinterface.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Supplier<String> defaultCity = () -> "Pune";

        System.out.print("Enter city (leave blank for default): ");
        String input = sc.nextLine();

        String city;
        if (input == null || input.trim().isEmpty()) {
            city = defaultCity.get(); // fallback
        } else {
            city = input;
        }

        System.out.println("Selected city: " + city);
    }
}