package com.akikun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _00120_Triangle {

    public static void main(String[] args) {
        List<Integer> line0 = Arrays.asList(2);
        List<Integer> line1 = Arrays.asList(3, 4);
        List<Integer> line2 = Arrays.asList(6,5,7);
        List<Integer> line3 = Arrays.asList(4,1,8,3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(line0);
        triangle.add(line1);
        triangle.add(line2);
        triangle.add(line3);

        _00120_Triangle test = new _00120_Triangle();
        int ans = test.minimumTotal(triangle);
        System.out.println("answer: " + ans);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int longLen = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[h][longLen];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < h; ++i) {
            for (int j = 0, len = triangle.get(i).size(); j < len; ++j) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];

                } else if (j == len - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < longLen; ++i) {
            if (dp[h - 1][i] < ans) {
                ans = dp[h - 1][i];
            }
        }

        return ans;
    }

}
