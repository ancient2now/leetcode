package com.akikun.leetcode;

public class _00209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        _00209_MinimumSizeSubarraySum test = new _00209_MinimumSizeSubarraySum();
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        int res = test.minSubArrayLen(s, nums);
        System.out.println(res);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int minRes = 0;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum >= s) {
                    int value = i - j + 1;
                    minRes = minRes == 0 ? value : Math.min(minRes, value);
                    break;
                }
            }
        }
        return minRes;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum >= s) {
                    int value = i - j + 1;
                    dp[i + 1] = dp[i] == 0
                            ? value
                            : Math.min(dp[i], value);
                    break;
                }

            }
        }
        return dp[nums.length];
    }
}
