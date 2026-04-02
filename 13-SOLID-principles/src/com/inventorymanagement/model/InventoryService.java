package com.inventorymanagement.model;

import java.util.*;

class InventoryService {

    private Map<String, Product> inventory = new HashMap<>();
    private List<Notifier> notifiers;
    private ReorderService reorderService;

    public InventoryService(List<Notifier> notifiers, ReorderService reorderService) {
        this.notifiers = notifiers;
        this.reorderService = reorderService;
    }

    public void addProduct(Product product) {

        if (inventory.containsKey(product.getName())) {
            throw new DuplicateProductException(
                    "Product '" + product.getName() + "' already exists!"
            );
        }

        inventory.put(product.getName(), product);
        System.out.println("Product added successfully!");
    }

    public void updateProduct(String name, int qty, double price, int reorderLevel) {

        Product p = inventory.get(name);

        if (p == null) {
            System.out.println("Product not found!");
            return;
        }

        p.setQuantity(qty);
        p.setPrice(price);
        p.setReorderLevel(reorderLevel);

        System.out.println("Product updated successfully!");
    }

    public void deleteProduct(String name) {

        if (!inventory.containsKey(name)) {
            System.out.println("Product not found!");
            return;
        }

        inventory.remove(name);
        System.out.println("Product deleted successfully!");
    }

    public void removeStock(String name, int qty) {

        Product p = inventory.get(name);

        if (p == null) {
            System.out.println("Product not found!");
            return;
        }

        if (qty > p.getQuantity()) {
            System.out.println("Not enough stock!");
            return;
        }

        p.setQuantity(p.getQuantity() - qty);

        System.out.println("Removed " + qty + " units of '" + name + "'");
        System.out.println("Current stock: " + p.getQuantity());

        if (p.getQuantity() <= p.getReorderLevel()) {
            System.out.println("Low stock! Triggering reorder...");

            reorderService.reorder(p);

            for (Notifier n : notifiers) {
                n.send("Low stock alert for '" + name + "'");
            }
        }
    }

    public void showInventory() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        double total = 0;

        System.out.println("\n===== Inventory =====");

        for (Product p : inventory.values()) {

            double value = p.getQuantity() * p.getPrice();
            total += value;

            System.out.println("------------------");
            System.out.println("Name     : " + p.getName());
            System.out.println("Quantity : " + p.getQuantity());
            System.out.println("Price    : " + p.getPrice());
            System.out.println("Value    : " + value);
        }

        System.out.println("------------------");
        System.out.println("Total Inventory Value: " + total);
    }
}
