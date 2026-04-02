package com.LibrarySystem.model;

import java.util.*;

public class LibraryManager {

    private Set<Book> books = new HashSet<>();

    private Queue<IssueRequest> waitingQueue = new LinkedList<>();


    public void addBook(Book book) {

        if(books.add(book))
            System.out.println("Book added");

        else
            System.out.println("Duplicate book not allowed");
    }


    private Book findBook(int id) {

        for(Book b : books)
            if(b.getBookId() == id)
                return b;

        return null;
    }


    public void requestBook(IssueRequest req) {

        Book book = findBook(req.getBookId());

        if(book == null) {
            System.out.println("Book not found");
            return;
        }

        if(book.getStatus() == BookStatus.AVAILABLE) {

            book.setStatus(BookStatus.ISSUED);

            System.out.println("Book issued to " + req.getRequester());
        }

        else {

            waitingQueue.add(req);

            System.out.println("Book currently issued. Added to waiting queue.");
        }
    }


    public void returnBook(int bookId) {

        Book book = findBook(bookId);

        if(book == null) {
            System.out.println("Book not found");
            return;
        }

        if(waitingQueue.isEmpty()) {

            book.setStatus(BookStatus.AVAILABLE);

            System.out.println("Book returned and now available");
        }

        else {

            IssueRequest next = waitingQueue.poll();

            System.out.println("Book issued to waiting user: " + next.getRequester());

            book.setStatus(BookStatus.ISSUED);
        }
    }


    public void showBooks() {

        for(Book b : books)
            System.out.println(b);
    }


    public void showSortedBooks() {

        TreeSet<Book> sorted = new TreeSet<>(books);

        for(Book b : sorted)
            System.out.println(b);
    }


    public void showWaitingQueue() {

        for(IssueRequest r : waitingQueue)
            System.out.println(r);
    }
}