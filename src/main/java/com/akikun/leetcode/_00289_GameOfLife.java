package com.akikun.leetcode;

/**
 * @completed 2020.05.20
 */
public class _00289_GameOfLife {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i)  {
            for (int j = 0; j < n; ++j) {
                int cnt = count(i, j, m, n, board);
                if ((board[i][j] & 1) == 1) {
                    if (cnt == 2 || cnt == 3) {
                        board[i][j] = 0b11;
                    }
                } else {
                    if (cnt == 3) {
                        board[i][j] = 0b10;
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j =0; j < n; ++j) {
                board[i][j] >>= 1;
            }
        }

    }

    private int count(int i, int j, int m, int n, int[][] board) {
        int cnt = (board[i][j] & 1) == 1 ? -1 : 0;
        for (int dx = -1; dx < 2; ++dx) {
            for (int dy = -1; dy < 2; ++dy) {
                int x = i + dx;
                int y = j + dy;
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if ((board[x][y] & 1) == 1) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
