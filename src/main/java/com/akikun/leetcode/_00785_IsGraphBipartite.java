package com.akikun.leetcode;

public class _00785_IsGraphBipartite {

    public static void main(String[] args) {
        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};

    }

    boolean isBi;
    static int A = 1; // 标记A
    static int B = 2; // 标记B 没有标记是0
    private int[] colors;
    public boolean isBipartite(int[][] graph) {
        isBi = true;
        int len = graph.length;
        colors = new int[len];

        for (int i = 0; i < len && isBi; ++i) {
            if (colors[i] == 0) {
                dfs(graph, i, A);
            }
        }

        return isBi;
    }

    private void dfs(int[][] graph, int node, int color) {
        colors[node] = color;
        int nextColor = (color + 1) % 2;
        for (int v : graph[node]) {
            if (colors[v] == 0) {
                dfs(graph, node, A);
                if (!isBi) {
                    return;
                }
            } else  if (colors[v] == nextColor) {
                isBi = false;
                return;
            }
        }
    }
}
