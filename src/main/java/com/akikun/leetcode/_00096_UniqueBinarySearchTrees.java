package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;
import com.akikun.leetcode.struct.TreeNode;

public class _00096_UniqueBinarySearchTrees {

    public static void main(String[] args) {
        _00096_UniqueBinarySearchTrees test = new _00096_UniqueBinarySearchTrees();
        int ans = test.numTrees(3); // Excepted: 5
        PrintUtils.printAnswer(ans);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
