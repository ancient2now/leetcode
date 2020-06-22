package com.akikun.leetcode.algorithm;

import com.akikun.leetcode.commons.PrintUtils;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321,10};
        new Sort().quickSort(arr);
        PrintUtils.printArray(arr);
    }

    /**
     * Quick sort
     *
     */
    public void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void qSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int a = start, b = end;
        while (a < b) {
            while (arr[b] > pivot && a < b) {
                b--;
            }
            while (arr[a] < pivot && a < b) {
                a++;
            }

            if (arr[a] == arr[b] && a < b) {
                a++;
            } else {
                swap(arr, a, b);
            }

            if (a - 1 > start) {
                qSort(arr, start, a - 1);
            }
            if (b + 1 < end) {
                qSort(arr, b + 1, end);
            }
        }
    }
}
