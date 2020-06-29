package com.akikun.leetcode;

import java.util.Arrays;

public class _00215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        _00215_KthLargestElementInAnArray test = new _00215_KthLargestElementInAnArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int ans = test.findKthLargest(nums, k);
        System.out.println(ans);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArr = Arrays.stream(nums).sorted().toArray();
        return sortedArr[nums.length - k];
    }
}
