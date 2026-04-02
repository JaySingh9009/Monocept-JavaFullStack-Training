package com.functionalinterface.function;

import java.util.function.Function;

public class Converter {
    public static void main(String[] args) {

        Function<Double, Double> cToF = c -> (c * 9/5) + 32;

        double[] temps = {0, 20, 37};

        for (double t : temps) {
            System.out.println(t + "°C -> " + cToF.apply(t) + "°F");
        }
    }
}
