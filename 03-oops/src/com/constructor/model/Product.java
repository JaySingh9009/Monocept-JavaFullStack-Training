package com.constructor.model;


public class Product {

    private int productId;       
    private double price;         
    private int stockQuantity;

    private Product() {
    }

    public Product(int productId, double price, int stockQuantity) {

        if (price <= 0) {
            System.out.println("Price must be greater than 0. Product not created.");
            return;
        }

        this.productId = productId;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        if (productId <= 0) {
            System.out.println("Product ID must be positive.");
            return;
        }
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }
}