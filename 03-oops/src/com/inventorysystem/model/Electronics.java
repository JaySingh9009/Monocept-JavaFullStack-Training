package com.inventorysystem.model;

public class Electronics extends Product {

    private String brand;

    public Electronics(int productId, String productName,
                       double basePrice, String brand) {

        super(productId, productName, basePrice);

        if(brand == null || brand.trim().isEmpty())
            throw new IllegalArgumentException("Brand cannot be empty");

        this.brand = brand;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Category : Electronics");
        System.out.println("Brand    : " + brand);
        System.out.println("----------------------------");
    }
}
