package com.stringutility.model;

public class StringUtility {

    
    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

  
    public String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public Integer getLength(String str) {
        if (str == null) {
            return null;
        }
        return str.length();
    }
}
