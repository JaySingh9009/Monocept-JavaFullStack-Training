package com.streamApi.Map;

import java.util.*;
import java.util.stream.*;

public class SquareNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
