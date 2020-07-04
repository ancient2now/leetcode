package com.akikun.leetcode;

public class _00032_LongestValidParentheses {

    public static void main(String[] args) {
        _00032_LongestValidParentheses test = new _00032_LongestValidParentheses();
        int ans = test.longestValidParentheses(")(())()(())");
        System.out.println(ans);
    }

    public int longestValidParentheses(String s) {
        int ans = 0, len;
        int[] dp = new int[len = s.length()];
        for (int i = 1; i < len; ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int pre;
                    if (dp[i - 1] > 0 && (pre = i - dp[i - 1] -1) >= 0 && s.charAt(pre) == '(') {
                        dp[i] = (pre >= 1 ? dp[pre - 1] : 0) + dp[i - 1] + 2;
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

}
