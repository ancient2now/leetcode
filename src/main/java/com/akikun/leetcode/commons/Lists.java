package com.akikun.leetcode.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    public static List<String> from(String listStr) {
        if (listStr.isEmpty()) {
            return null;
        }
        if (!listStr.startsWith("[") || !listStr.endsWith("]")) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String[] arr = listStr.substring(1, listStr.length() - 1).split(",");
        for (String str : arr) {
            String temp = str.trim();
            list.add(temp.substring(1, temp.length() - 1));
        }
        return list;
    }

    public static <E> List<E> of(E... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <E> void print(List<E> list) {
        String res = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }

}
