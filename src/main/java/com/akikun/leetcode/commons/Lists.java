package com.akikun.leetcode.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    /**
     * transfer string to list
     * @param listStr the string like ["hello", "", "world"]
     * @return a new list
     */
    public static List<String> from(String listStr) {
        List<String> list = new ArrayList<>();
        if (listStr.isEmpty()) {
            return list;
        }
        if (!listStr.startsWith("[") || !listStr.endsWith("]")) {
            return list;
        }
        String[] arr = listStr.substring(1, listStr.length() - 1).split(",");
        for (String str : arr) {
            String temp = str.trim();
            if (temp.startsWith("\"") && temp.endsWith("\"")) {
                temp = temp.substring(1, temp.length() - 1);
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * construct a list by of function
     *
     * @param elements the element of the list
     * @param <E> element type
     * @return a new list
     */
    public static <E> List<E> of(E... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <E> void print(List<E> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(list.size()).append(" [");
        String content = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        sb.append(content).append("]");
        System.out.println(sb.toString());
    }

}
