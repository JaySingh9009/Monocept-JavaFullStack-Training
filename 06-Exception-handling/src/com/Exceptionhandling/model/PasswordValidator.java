package com.Exceptionhandling.model;

public class PasswordValidator {

    public void checkPassword(String pwd) throws InvalidPasswordException {

        if (pwd.length() < 8) {
            throw new InvalidPasswordException(
                "Password must be at least 8 characters long."
            );
        }

        boolean hasDigit = false;

        for (char ch : pwd.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit) {
            throw new InvalidPasswordException(
                "Password must contain at least one digit."
            );
        }

        System.out.println("Password is valid.");
    }
}