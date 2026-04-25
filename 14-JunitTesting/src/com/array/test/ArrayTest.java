package com.array.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.array.model.Array;

public class ArrayTest {

    Array util = new Array();

    @Test
    void testReverseNormalArray() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};

        assertArrayEquals(expected, util.reverseArray(input));
    }

    @Test
    void testReverseSingleElement() {
        int[] input = {5};
        int[] expected = {5};

        assertArrayEquals(expected, util.reverseArray(input));
    }

    @Test
    void testReverseEmptyArray() {
        int[] input = {};
        int[] expected = {};

        assertArrayEquals(expected, util.reverseArray(input));
    }

    @Test
    void testReverseNullArray() {
        assertNull(util.reverseArray(null));
    }
}
