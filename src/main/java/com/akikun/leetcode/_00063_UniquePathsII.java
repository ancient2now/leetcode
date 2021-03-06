package com.akikun.leetcode;

public class _00063_UniquePathsII {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0] == 1 ? 0 : 1;
        for (int[] ints : grid) {
            for (int j = 0; j < n; ++j) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
