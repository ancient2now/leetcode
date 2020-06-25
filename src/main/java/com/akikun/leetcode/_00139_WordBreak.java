package com.akikun.leetcode;

import java.util.Arrays;
import java.util.List;

public class _00139_WordBreak {

    public static void main(String[] args) {
        String s1 = "applepenapple";
        String[] wordDictArr1 = {"apple", "pen"};
        List<String> wordDict1 = Arrays.asList(wordDictArr1);

        String s2 = "catsandog";
        String[] wordDictArr2 = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict2 = Arrays.asList(wordDictArr2);

        _00139_WordBreak test = new _00139_WordBreak();
        boolean res1 = test.wordBreak(s1, wordDict1);
        boolean res2 = test.wordBreak(s2, wordDict2);
        System.out.println(res1);
        System.out.println(res2);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
