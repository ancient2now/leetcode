package com.akikun.leetcode.commons;

import java.util.stream.Collectors;

public class Arrays {

    public static <E> void print(E[] arr) {
        String arrStr = java.util.Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.err.println("length:" + arr.length + "; values:" + arrStr);
    }

}
