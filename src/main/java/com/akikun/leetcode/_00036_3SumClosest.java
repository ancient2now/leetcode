package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;

import java.util.Arrays;

public class _00036_3SumClosest {

    public static void main(String[] args) {
        _00036_3SumClosest test = new _00036_3SumClosest();
        int[] nums = {1,1,1,0};
        int ans = test.threeSumClosest(nums, 100);
        PrintUtils.printAnswer(ans);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = nums[0] + nums[1] + nums[n-1];

        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = i + 1, b = n - 1;
            while(a < b) {
                int sum = nums[i] + nums[a] + nums[b];
                if (sum == target) {
                    return sum;
                }
                if (sum != best) {
                    if (Math.abs(target - sum) < Math.abs(target - best)) {
                        best = sum;
                    }
                }
                if (sum < target) {
                    a++;
                } else {
                    b--;
                }
            }
        }

        return best;

    }
}
