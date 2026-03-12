package com.String.model;

public class EmailAnalyzer {

    private String email;

    public EmailAnalyzer(String email) {
        this.email = email;
    }

    public String getUsername() {
        int atIndex = email.indexOf("@");
        return email.substring(0, atIndex);
    }

    public String getDomain() {
        int atIndex = email.indexOf("@");
        return email.substring(atIndex + 1);
    }

    public int getUsernameLength() {
        return getUsername().length();
    }

    public boolean hasDigitsInUsername() {
        String username = getUsername();

        for (char c : username.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public String getModifiedUsername() {
        return getUsername().replace(".", "_");
    }

    public boolean isGmail() {
        return getDomain().equalsIgnoreCase("gmail.com");
    }

    public String getLowerCaseEmail() {
        return email.toLowerCase();
    }
}