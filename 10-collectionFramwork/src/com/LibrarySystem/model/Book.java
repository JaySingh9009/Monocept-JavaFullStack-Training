package com.LibrarySystem.model;

import java.util.Objects;

public abstract class Book implements Comparable<Book> {

    private int bookId;
    private String title;
    private String author;
    private BookStatus status;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.status = BookStatus.AVAILABLE;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public abstract String getType();

    @Override
    public int compareTo(Book b) {
        return this.title.compareToIgnoreCase(b.title);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null || !(obj instanceof Book)) return false;

        Book book = (Book) obj;

        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {

        return "ID: " + bookId +
                " | Title: " + title +
                " | Author: " + author +
                " | Type: " + getType() +
                " | Status: " + status;
    }
}