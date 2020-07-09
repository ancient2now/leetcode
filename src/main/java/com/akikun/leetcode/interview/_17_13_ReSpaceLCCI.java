package com.akikun.leetcode.interview;

public class _17_13_ReSpaceLCCI {

    public static void main(String[] args) {
        _17_13_ReSpaceLCCI test = new _17_13_ReSpaceLCCI();

        String[] dic = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother"; // Excepted: 7
        int respace = test.respace(dic, sentence);
        System.out.println(respace);
    }

    public int respace(String[] dic, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int k = 0; k < dic.length; ++k) {
                if (dic[k].length() <= i) {
                    if (dic[k].equals(sentence.substring(i - dic[k].length(), i))) {
                        dp[i] = Math.min(dp[i - dic[k].length()], dp[i]);
                    }
                }
            }
        }
        return dp[len];
    }

}
