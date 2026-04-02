package com.streamApi.Map;
import java.util.*;
import java.util.stream.*;

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


public class DiscountProducts {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Shoes", 1000),
                new Product("Bag", 500)
        );

        List<Product> discounted = products.stream()
                .map(p -> new Product(p.name, p.price * 0.9))
                .collect(Collectors.toList());

        discounted.forEach(System.out::println);
    }
}