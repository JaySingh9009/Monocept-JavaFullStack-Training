package com.functionalinterface.supplier;

import java.util.*;
import java.util.function.Supplier;

public class ProductListGenerator {
    public static void main(String[] args) {

        Supplier<List<String>> productSupplier = () -> {
            List<String> products = new ArrayList<>();
            products.add("Laptop");
            products.add("Mobile");
            products.add("Tablet");
            products.add("Headphones");
            products.add("Camera");
            return products;
        };

        List<String> products = productSupplier.get();

        System.out.println("Product List:");
        for (String p : products) {
            System.out.println(p);
        }
    }
}