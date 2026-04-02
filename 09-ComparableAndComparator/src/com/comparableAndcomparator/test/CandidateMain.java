package com.comparableAndcomparator.test;
import java.util.*;

import com.comparableAndcomparator.model.Candidate;
import com.comparableAndcomparator.model.CandidateComparator;

public class CandidateMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        while (true) {
            System.out.print("Enter number of candidates: ");
            n = sc.nextInt();

            if (n > 0)
                break;
            else
                System.out.println("Number of candidates must be positive.");
        }

        sc.nextLine();

        List<Candidate> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String name;

            while (true) {
                System.out.print("Enter name: ");
                name = sc.nextLine();

                if (!name.trim().isEmpty())
                    break;
                else
                    System.out.println("Name cannot be empty.");
            }

            int age;

            while (true) {
                System.out.print("Enter age: ");
                age = sc.nextInt();

                if (age >= 0)
                    break;
                else
                    System.out.println("Age cannot be negative.");
            }

            sc.nextLine();

            list.add(new Candidate(name, age));
        }

        Collections.sort(list, new CandidateComparator());

        System.out.println("\nSorted Candidates:");

        for (Candidate c : list) {
            System.out.println(c);
        }

        sc.close();
    }
}