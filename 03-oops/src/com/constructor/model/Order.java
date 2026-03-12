package com.constructor.model;


public class Order {

    private static int idCounter = 1000;

    protected int orderId;
    protected Product product;
    protected int quantity;
    protected double totalAmount;

    private Order() {
        this.orderId = ++idCounter;
    }
    public Order(Product product, int quantity) {
        this();  

        if (product == null) {
            System.out.println("Order cannot be created without a Product.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0. Order not created.");
            return;
        }

        this.product = product;
        this.quantity = quantity;

        this.totalAmount = product.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}