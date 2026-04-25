package com.person.model;

public class Person {

    private String name;
    private int age;
    private String status;

    public Person(String name, int age, String status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }
}
