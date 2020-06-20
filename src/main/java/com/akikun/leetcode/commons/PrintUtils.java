package com.akikun.leetcode.commons;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintUtils {

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

    public static void printArray(int[] arr) {
        String arrStr = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.err.println("length:" + arr.length + "; values:" + arrStr);
    }
}
