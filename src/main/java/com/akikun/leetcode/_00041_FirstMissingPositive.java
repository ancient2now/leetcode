package com.akikun.leetcode;

import java.util.Arrays;

public class _00041_FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        _00041_FirstMissingPositive test = new _00041_FirstMissingPositive();
        int res = test.firstMissingPositive(nums);
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        int[] positiveNum = Arrays.stream(nums)
                .filter(a -> a > 0).sorted().distinct().toArray();
        for (int i = 0; i < positiveNum.length; ++i) {
            if (positiveNum[i] > (i + 1)) {
                return (i + 1);
            }
        }
        return positiveNum.length + 1;
    }
}
