package com.comparableAndcomparator.model;

public class Candidate {
    String name;
    int age;

    public Candidate(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " - " + age;
    }
}
