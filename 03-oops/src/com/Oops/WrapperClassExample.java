package com.Oops;

import java.util.*;

public class WrapperClassExample {
    public static void main(String[] args) {

        int a = 10;
        Integer objA = a;   
        
        int b = objA;     

        System.out.println("Primitive int: " + a);
        System.out.println("Wrapper Integer: " + objA);
        System.out.println("Unboxed int: " + b);

        Integer c=Integer.valueOf(a);
        int i=objA.intValue();
        System.out.println(c);
        System.out.println(i);
        
    }
}
