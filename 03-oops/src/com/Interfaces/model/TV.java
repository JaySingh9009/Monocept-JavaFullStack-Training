package com.Interfaces.model;

public class TV implements Controllable {

    @Override
    public void turnOn() {
        System.out.println("TV turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned OFF");
    }

    @Override
    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("HD") ||
            mode.equalsIgnoreCase("FullHD") ||
            mode.equalsIgnoreCase("4K")) {
            System.out.println("TV mode set to: " + mode);
        } else {
            System.out.println("Invalid mode for TV. Valid modes: HD, FullHD, 4K");
        }
    }
}