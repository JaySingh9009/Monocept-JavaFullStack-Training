package com.LibrarySystem.model;

public class Magazine extends Book {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public String getType() {
        return "Magazine";
    }
}
