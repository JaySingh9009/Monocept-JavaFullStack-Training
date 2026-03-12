package com.constructor.model;


public class DiscountedOrder extends Order {

    private double discountPercentage;

    public DiscountedOrder(Product product, int quantity, double discountPercentage) {
        super(product, quantity);  
        if (discountPercentage < 0 || discountPercentage > 100) {
            System.out.println("Invalid discount percentage. Discount not applied.");
            this.discountPercentage = 0;
            return;
        }

        this.discountPercentage = discountPercentage;

        double discountAmount = (this.totalAmount * discountPercentage) / 100;
        this.totalAmount = this.totalAmount - discountAmount;
    }
}