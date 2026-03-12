package com.Inheritance.model;
public class EmailNotification extends Notification {

    public EmailNotification(String recipient, String message) {
        super(recipient, message);   
    }

    @Override
    public void send() {
        super.logNotification();    
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}