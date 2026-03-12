package com.inventorysystem.model;

public class Clothing extends Product {

    private String size;

    public Clothing(int productId, String productName,
                    double basePrice, String size) {

        super(productId, productName, basePrice);

        if(size == null || size.trim().isEmpty())
            throw new IllegalArgumentException("Size cannot be empty");

        this.size = size;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Category : Clothing");
        System.out.println("Size     : " + size);
        System.out.println("----------------------------");
    }
}
