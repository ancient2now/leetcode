package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class _00329_LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        _00329_LongestIncreasingPathInAMatrix test = new _00329_LongestIncreasingPathInAMatrix();
        int[][] matrix = {{1,2},{2,3}};
        int ans = test.longestIncreasingPath(matrix);
        PrintUtils.printAnswer(ans);
    }

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        Deque<int[]> deque = new ArrayDeque<>();

        int ans = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (memo[i][j] > 0) {
                    continue;
                }
                deque.addFirst(new int[]{i, j});
                int count = 1;
                while (!deque.isEmpty()) {
                    count++;
                    int len = deque.size();
                    for (int k = 0; k < len; ++k) {
                        int[] pos = deque.poll();
                        for (int z = 0; z < 4; ++z) {
                            int x = pos[0] + dx[z];
                            int y = pos[1] + dy[z];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                continue;
                            }
                            if (count <= memo[x][y] || matrix[x][y] <= matrix[pos[0]][pos[1]]) {
                                continue;
                            }
                            memo[x][y] = count;
                            ans = Math.max(count, ans);
                            deque.add(new int[]{x, y});
                        }

                    }
                }
            }
        }

        return ans;

    }

}
