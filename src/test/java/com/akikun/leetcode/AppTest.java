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

    @Test
    public void reverseWords() {
        String s = "  8   ";
        System.out.print(reverseWords(s));
        System.out.println("@");

    }

    private String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        if(arr.length == 0 || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > -1; --i) {
            if (!arr[i].isEmpty()) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    @Test
    public void gameOfLife() {

        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        gameOfLife(board);

        printMatrix(board);


    }

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

    public void printMatrix(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sb.append(board[i][j]).append(',');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

}
