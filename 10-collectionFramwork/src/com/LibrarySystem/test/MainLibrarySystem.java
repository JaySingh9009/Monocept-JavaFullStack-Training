package com.LibrarySystem.test;

import com.LibrarySystem.model.*;

public class MainLibrarySystem {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();

        System.out.println("====================================");
        System.out.println("     LIBRARY BOOK CIRCULATION SYSTEM");
        System.out.println("====================================");

        int choice;

        do {

            System.out.println("\n1 Add Book");
            System.out.println("2 Show Books");
            System.out.println("3 Request Book");
            System.out.println("4 Return Book");
            System.out.println("5 Show Sorted Books");
            System.out.println("6 Show Waiting Queue");
            System.out.println("0 Exit");

            choice = InputValidator.readChoice("Enter choice: ");

            switch (choice) {

                case 1:

                    int id = InputValidator.readBookId("Enter Book ID: ");

                    String title = InputValidator.readString("Enter Title: ");

                    String author = InputValidator.readString("Enter Author: ");

                    System.out.println("1 Academic Book");
                    System.out.println("2 Magazine");

                    int type = InputValidator.readChoice("Enter type: ");

                    if (type == 1)
                        manager.addBook(new AcademicBook(id, title, author));
                    else
                        manager.addBook(new Magazine(id, title, author));

                    break;

                case 2:
                    manager.showBooks();
                    break;

                case 3:

                    int bid = InputValidator.readBookId("Enter Book ID: ");

                    String requester = InputValidator.readString("Enter requester name: ");

                    manager.requestBook(new IssueRequest(bid, requester));

                    break;

                case 4:

                    int rid = InputValidator.readBookId("Enter Book ID to return: ");

                    manager.returnBook(rid);

                    break;

                case 5:
                    manager.showSortedBooks();
                    break;

                case 6:
                    manager.showWaitingQueue();
                    break;

            }

        } while (choice != 0);
    }
}