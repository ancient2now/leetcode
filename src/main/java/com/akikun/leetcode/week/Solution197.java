package com.akikun.leetcode.week;

import java.util.*;
import java.util.stream.Collectors;

public class Solution197 {

    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int j = 0; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public int numSub(String s) {
        char[] arr = s.toCharArray();
        int sum = 0, count=0;
        int mod =  (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '0') {
                count = 0;
            } else {
                count++;
                sum += count;
                if (sum >= mod) {
                    sum %= mod;
                }
            }
        }
        return sum;
    }


    private int[] visited;
    private double[] map;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        map = new double[n];
        map[start] = 1.0;
        visited = new int[edges.length];
        dfs(edges, succProb, start);
        return map[end];
    }

    private void dfs(int[][] edges, double[] succProb, int start) {
        Set<Integer> endSet = new HashSet<>();
        for (int i = 0; i < edges.length; ++i) {
            int s = edges[i][0], e = edges[i][1];
            if (visited[i] == 0 && (s == start || e == start))  {
                if (s != start) {
                    int temp = s;
                    s = e;
                    e = temp;
                }
                endSet.add(e);
                visited[i] = 1;
                if (map[s] != 0) {
                    if (map[e] != 0) {
                        map[e] = Math.max(map[e], map[s] * succProb[i]);
                    } else {
                        map[e] = map[s] * succProb[i];
                    }
                } else {
                    if (map[e] == 0) {
                        map[e] = Math.max(map[e], succProb[i]);
                    } else {
                        map[e] = succProb[i];
                    }

                }
            }
        }
        if (!endSet.isEmpty())  {
            for (Integer nextStart : endSet) {
                dfs(edges, succProb, nextStart);
            }
        }
    }
}
