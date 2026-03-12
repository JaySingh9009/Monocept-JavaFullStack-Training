package com.Inheritance.model;
public class Notification {

    protected String recipient;
    protected String message;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public void logNotification() {
        System.out.println("[LOG] Notification prepared for: " + recipient);
    }

    public void send() {
        logNotification();
        System.out.println("Sending notification to " + recipient + "...");
    }
}
