package com.akikun.leetcode;

import java.util.Stack;

public class _00032_LongestValidParentheses {

    public static void main(String[] args) {
        _00032_LongestValidParentheses test = new _00032_LongestValidParentheses();
        String example = ")(())()(())";
        int ans1 = test.longestValidParentheses_DP(example);
        int ans2 = test.longestValidParentheses_Stack(example);
        System.out.println("answer1: " + ans1);
        System.out.println("answer2: " + ans2);
    }

    public int longestValidParentheses_DP(String s) {
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

    public int longestValidParentheses_Stack(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

}
