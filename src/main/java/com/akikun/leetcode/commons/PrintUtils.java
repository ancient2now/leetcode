package com.akikun.leetcode.commons;

import java.util.List;
import java.util.stream.Collectors;

public class PrintUtils {

    public static void printAnswer(Object o) {
        System.out.println("Answer: " + o.toString());
    }

    public static void printMatrix(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sb.append(board[i][j]).append(',');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static <E> void printArray(E[] arr) {
        MyArrays.print(arr);
    }

    public static void printArray(int[] arr) {
        String arrStr = java.util.Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.err.println("length:" + arr.length + "; values:" + arrStr);
    }

    public static <E> void printList(List<E> list) {
        MyLists.print(list);
    }
}
