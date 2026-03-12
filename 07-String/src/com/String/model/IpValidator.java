package com.String.model;
public class IpValidator {

    public boolean isValid(String ip) {

        String[] parts = ip.split("\\.");

        if (parts.length != 4)
            return false;

        for (String part : parts) {

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255)
                return false;
        }

        return true;
    }
}