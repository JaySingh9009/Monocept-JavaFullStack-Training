package com.comparableAndcomparator.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.comparableAndcomparator.model.Movie;
import com.comparableAndcomparator.model.MovieComparator;

public class MovieMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Movie> list = new ArrayList<>();

        int n;

        while (true) {
            System.out.print("Enter number of movies: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0)
                    break;
                else
                    System.out.println("Number must be positive.");
            } else {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {

            String title;

            while (true) {
                System.out.print("Enter movie title: ");
                title = sc.nextLine();

                if (!title.trim().isEmpty())
                    break;
                else
                    System.out.println("Title cannot be empty.");
            }

            int year;

            while (true) {
                System.out.print("Enter movie year: ");

                if (sc.hasNextInt()) {
                    year = sc.nextInt();
                    sc.nextLine();

                    if (year > 0)
                        break;
                    else
                        System.out.println("Year must be positive.");
                } else {
                    System.out.println("Invalid year.");
                    sc.nextLine();
                }
            }

            list.add(new Movie(title, year));
        }

        Collections.sort(list, new MovieComparator());

        System.out.println("\nSorted Movies:");

        for (Movie m : list) {
            System.out.println(m);
        }

        sc.close();
    }
}
