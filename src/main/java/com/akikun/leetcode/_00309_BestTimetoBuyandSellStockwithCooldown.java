package com.akikun.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _00309_BestTimetoBuyandSellStockwithCooldown {

    public static void main(String[] args) {
        _00309_BestTimetoBuyandSellStockwithCooldown test = new _00309_BestTimetoBuyandSellStockwithCooldown();
        int[] prices = {1,2,3,0,2};
        int ans = test.maxProfit(prices);
        System.out.println("answer: " + ans);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        // 0: have stock; 1: sell stock; 2: no stock
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
