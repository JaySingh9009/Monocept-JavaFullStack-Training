package com.LibrarySystem.model;

public class AcademicBook extends Book {

    public AcademicBook(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public String getType() {
        return "Academic Book";
    }
}
