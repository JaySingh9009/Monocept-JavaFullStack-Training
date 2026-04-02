package com.inventorymanagement.model;

public class ReorderService {
    public void reorder(Product product) {
        int reorderQty = 20;
        product.setQuantity(product.getQuantity() + reorderQty);
        System.out.println("Reorder placed for " + reorderQty + " units of '" + product.getName() + "'");
    }
}