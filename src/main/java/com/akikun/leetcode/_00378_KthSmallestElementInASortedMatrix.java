package com.akikun.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _00378_KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        _00378_KthSmallestElementInASortedMatrix test = new _00378_KthSmallestElementInASortedMatrix();

    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] sortedArr = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
        return sortedArr[k - 1];
    }
}
