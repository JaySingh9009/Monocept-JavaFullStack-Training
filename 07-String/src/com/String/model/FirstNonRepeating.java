package com.String.model;

public class FirstNonRepeating {

    public char findFirst(String str) {

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (c == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return c;
            }
        }

        return '_';
    }
}
