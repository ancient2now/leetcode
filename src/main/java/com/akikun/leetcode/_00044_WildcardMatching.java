package com.akikun.leetcode;

public class _00044_WildcardMatching {

    public static void main(String[] args) {
        _00044_WildcardMatching test = new _00044_WildcardMatching();
        String s1 = "adceb", p1 = "*a*b"; // true
        boolean ans1 = test.isMatch(s1, p1);
        System.out.println("answer1: " + ans1);

        String s2 = "cb", p2 = "?a"; // false
        boolean ans2 = test.isMatch(s2, p2);
        System.out.println("answer2: " + ans2);
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int[][] dp = new int[sLen + 1][pLen + 1]; // 1: true, 0: false
        dp[0][0] = 1;

        for (int i = 1; i <= pLen; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = 1;
            }
            else {
                break;
            }
        }

        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < pLen; ++j) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                }  else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = (dp[i + 1][j] + dp[i][j + 1] + dp[i][j]) > 0 ? 1 : 0;
                }
            }
        }
        return dp[sLen][pLen] == 1;
    }
}
