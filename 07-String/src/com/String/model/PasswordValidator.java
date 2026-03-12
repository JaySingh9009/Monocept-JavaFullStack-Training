package com.String.model;


public class PasswordValidator {

    private String password;

    public PasswordValidator(String password) {
        this.password = password.replace(" ", "");
    }

    public boolean isLengthValid() {
        return password.length() >= 8;
    }

    public boolean hasUpperCase() {

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasLowerCase() {

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasDigit() {

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidPassword() {

        return isLengthValid() && hasUpperCase() && hasLowerCase() && hasDigit();
    }
}
