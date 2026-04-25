package com.project.app.controller;


public class Validator {

    public static void validateId(int id) throws Exception {
        if (id <= 0) throw new Exception("ID must be positive");
    }

    public static void validateName(String name) throws Exception {
        if (!name.matches("[a-zA-Z ]+"))
            throw new Exception("Invalid name");
    }

    public static void validateRange(int val, int min, int max) throws Exception {
        if (val < min || val > max)
            throw new Exception("Value must be between " + min + " and " + max);
    }
}