package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;

public class _00174_DungeonGame {

    public static void main(String[] args) {
        _00174_DungeonGame test = new _00174_DungeonGame();
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}}; // Excepted: 7
        int ans = test.calculateMinimumHP(dungeon);
        PrintUtils.printAnswer(ans);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m- 1][n - 1] = 1;
        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (i + 1 == m && j + 1 == n) {
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                    continue;
                }
                int right = j + 1 < n ? dp[i][j + 1] : Integer.MAX_VALUE;
                int down = i + 1 < m ? dp[i + 1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.max(Math.min(right, down) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
