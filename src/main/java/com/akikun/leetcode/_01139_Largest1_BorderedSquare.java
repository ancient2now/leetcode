package com.akikun.leetcode;

public class _01139_Largest1_BorderedSquare {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        _01139_Largest1_BorderedSquare test = new _01139_Largest1_BorderedSquare();
        int ans = test.largest1BorderedSquare(grid);
        System.out.println(ans);
    }

    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = 0, res = 0;
        if(n == 0) return 0;
        m = grid[0].length;

        // record how many '1' are on the left
        int[][] left = new int[n + 1][m + 1];
        // record how many '1' are on the upward
        int[][] up = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int d = 0;
                if(grid[i - 1][j - 1] == 1){
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    d = Math.min(left[i][j - 1], up[i - 1][j]);
                    while(d > 0){
                        if(up[i][j - d]  > d &&  left[i - d][j] > d) {
                            break;
                        }
                        d--;
                    }
                    res = Math.max(res, d + 1);
                }
            }
        }
        return res * res;
    }

}
