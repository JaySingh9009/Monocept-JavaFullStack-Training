package com.encapsulation.model;

public class Product {

    private final String productId;

    private String productName;
    private double price;
    private int stockQuantity;

    private boolean discontinued;
    private boolean validProduct;   

    public Product(String productId, String productName, double price, int initialStock) {

        this.productId = productId;

        if (productId == null || productId.trim().isEmpty()) {
            System.out.println("Product ID cannot be empty");
            validProduct = false;
            return;
        }

        if (productName == null || productName.trim().isEmpty()) {
            System.out.println("Product name cannot be empty");
            validProduct = false;
            return;
        }

        if (price < 0) {
            System.out.println("Price cannot be negative");
            validProduct = false;
            return;
        }

        if (initialStock < 0) {
            System.out.println("Stock cannot be negative");
            validProduct = false;
            return;
        }

        this.productName = productName;
        this.price = price;
        this.stockQuantity = initialStock;
        this.discontinued = false;
        this.validProduct = true;
    }
    
    public boolean isValidProduct() {
        return validProduct;
    }


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        if (!validProduct) {
            System.out.println("Invalid product. Price unavailable.");
            return 0.0;
        }
        return price;
    }

    public int getStockQuantity() {
        if (!validProduct) {
            System.out.println("Invalid product. Stock unavailable.");
            return 0;
        }
        return stockQuantity;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void updatePrice(double newPrice) {
        if (!validProduct) {
            System.out.println("Invalid product. Operation not allowed.");
            return;
        }
        if (discontinued) {
            System.out.println("Discontinued product cannot be modified");
            return;
        }
        if (newPrice < 0) {
            System.out.println("Price cannot be negative");
            return;
        }
        this.price = newPrice;
        System.out.println("Price updated successfully");
    }

    public void increaseStock(int quantity) {
        if (!validProduct) {
            System.out.println("Invalid product. Operation not allowed.");
            return;
        }
        if (discontinued) {
            System.out.println("Discontinued product cannot be modified");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Increase quantity must be positive");
            return;
        }
        stockQuantity += quantity;
        System.out.println("Stock increased successfully");
    }

    public void reduceStock(int quantity) {
        if (!validProduct) {
            System.out.println("Invalid product. Operation not allowed.");
            return;
        }
        if (discontinued) {
            System.out.println("Discontinued product cannot be modified");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Reduction quantity must be positive");
            return;
        }
        if (quantity > stockQuantity) {
            System.out.println("Insufficient stock");
            return;
        }
        stockQuantity -= quantity;
        System.out.println("Stock reduced successfully");
    }

    public void discontinueProduct() {
        if (!validProduct) {
            System.out.println("Invalid product. Operation not allowed.");
            return;
        }
        this.discontinued = true;
        System.out.println("Product discontinued");
    }
}
