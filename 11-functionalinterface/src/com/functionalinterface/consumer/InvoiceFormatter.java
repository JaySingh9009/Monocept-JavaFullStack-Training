package com.functionalinterface.consumer;

import java.util.*;
import java.util.function.Consumer;

class Invoice {
    String itemName;
    int quantity;
    int price;

    Invoice(String itemName, int quantity, int price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InvoiceFormatter {
    public static void main(String[] args) {

        List<Invoice> invoices = Arrays.asList(
            new Invoice("Pen", 2, 10),
            new Invoice("Notebook", 3, 50),
            new Invoice("Pencil", 5, 5)
        );

        Consumer<Invoice> printBill = inv -> {
            int total = inv.quantity * inv.price;
            System.out.println("Item: " + inv.itemName +
                               " | Quantity: " + inv.quantity +
                               " | Total: " + total);
        };

        for (Invoice inv : invoices) {
            printBill.accept(inv);
        }
    }
}
