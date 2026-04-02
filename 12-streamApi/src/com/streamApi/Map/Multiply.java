package com.streamApi.Map;

import java.util.*;
import java.util.stream.*;

public class Multiply {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> result = numbers.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
