package com.akikun.leetcode.bytedance;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland test = new MaxAreaOfIsland();
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}; // exceptedt: 4
        int ans = test.maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if ((x < 0 || x >= m) || (y < 0 || y >= n)
                || grid[x][y] == 0 || grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2; // 2: visited
        int count = 1;
        for (int i = 0; i < 4; ++i) {
            count += dfs(grid, x + dx[i], y + dy[i]);
        }
        return count;
    }
}
