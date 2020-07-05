package com.akikun.leetcode.week;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/weekly-contest-196
 */
public class Solution196 {

    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length <= 2) {
            return true;
        }
        int sub = arr[1]- arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i-1] != sub) {
                return false;
            }
        }
        return true;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int a : left) {
            ans = Math.max(ans, a);
        }
        for (int a : right) {
            ans = Math.max(ans, n - a);
        }
        return ans;
    }

    public int numSubmat_1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int[] line = Arrays.copyOf(mat[i], n);
            ans += countLine(line);

            for (int j = i + 1; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    line[k] = line[k] & mat[j][k];
                }
                ans += countLine(line);
            }
        }
        return ans;
    }

    private int countLine(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                res += count * (count + 1) >> 1;
                count = 0;
                continue;
            }
            count ++;
        }
        res += count * (count + 1) >> 1;
        return res;
    }

    public int numSubmat_2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1 && j > 0) {
                    mat[i][j] = mat[i][j - 1] + 1;
                }
                for (int k = i, width = 151; k >= 0; --k) {
                    width = Math.min(width, mat[k][j]);
                    ans += width;
                }
            }
        }
        return ans;
    }

    public String minInteger(String num, int k) {
        char[] nums = num.toCharArray();
        for (int i = 0; i < nums.length; ++i) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length && j - i <= k; ++j) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            k = k - (minIdx - i);
            for (int j = minIdx; j > i; --j) {
                swap(nums, j, j - 1);
            }
            if (k == 0) break;
        }
        return new String(nums);
    }

    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
