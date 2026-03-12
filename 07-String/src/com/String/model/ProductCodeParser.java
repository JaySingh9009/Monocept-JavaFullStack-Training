package com.String.model;

public class ProductCodeParser {

    private String productCode;
    private String[] parts;

    public ProductCodeParser(String productCode) {
        this.productCode = productCode;
        parts = productCode.split("-");
    }

    public String getCategory() {
        return parts[0].toUpperCase();
    }

    public String getProductName() {
        return parts[1];
    }

    public String getYear() {
        return parts[2];
    }

    public boolean startsWithTV() {
        return getProductName().startsWith("TV");
    }

    public boolean endsWith2023() {
        return productCode.endsWith("2023");
    }

    public String getModifiedCode() {
        return getCategory() + " " + getProductName() + " " + getYear();
    }

    public int getFirstHyphenPosition() {
        return productCode.indexOf("-");
    }
}