package com.akikun.leetcode.commons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyArrays {

    public static <E> void print(E[] arr) {
        String arrStr = java.util.Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.err.println("length:" + arr.length + "; values:" + arrStr);
    }

    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

}
