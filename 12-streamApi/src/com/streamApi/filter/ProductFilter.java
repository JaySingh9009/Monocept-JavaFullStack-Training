package com.streamApi.filter;
import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " : " + price;
    }
}


public class ProductFilter {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Shoes", 1200),
                new Product("Pen", 50),
                new Product("Bag", 700),
                new Product("Book", 300)
        );

        products.stream()
                .filter(p -> p.price > 500)
                .forEach(System.out::println);
    }
}