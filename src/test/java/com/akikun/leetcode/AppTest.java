package com.akikun.leetcode;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.print("Hello LeetCode");
    }

    @Test
    public void movingCount() {
        System.out.print(movingCount(1, 2, 1));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x >= m || y >=n || visited[x][y] || compute(x, y) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k, visited) + dfs(x, y + 1, m, n, k, visited);
    }

    private int compute(int x, int y) {
        return x % 10 + x / 10 + y % 10 + y / 10;
    }

}
