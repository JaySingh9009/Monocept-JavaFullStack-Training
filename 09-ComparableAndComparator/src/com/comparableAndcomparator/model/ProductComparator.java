package com.comparableAndcomparator.model;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {

        int categoryCompare = p1.getCategory().compareTo(p2.getCategory());

        if (categoryCompare != 0) {
            return categoryCompare;
        }

        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
