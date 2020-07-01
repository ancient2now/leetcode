package com.akikun.leetcode;

public class _00718_MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        _00718_MaximumLengthOfRepeatedSubarray test = new _00718_MaximumLengthOfRepeatedSubarray();
        int[] A = {1,2,3,2,1,4};
        int[] B = {3,2,1,4,7};
        int ans1 = test.findLength_dp(A, B); // Except: 4
        int ans2 = test.findLength(A, B); // Except: 4
        System.out.println("DP Answer: " + ans1);
        System.out.println("Slide Answer: " + ans2);
    }

    // dp solution
    public int findLength_dp(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int a = 0; a < A.length; ++a) {
            for (int b = 0; b < B.length; ++b) {
                if (A[a] == B[b]) {
                    ans = Math.max(ans, dp[a + 1][b + 1] = dp[a][b] + 1);
                }
            }
        }
        return ans;
    }

    // slide solution
    public int findLength(int[] A, int[] B) {
        int minSize = Math.min(A.length, B.length);
        int ans = 0;
        for (int i = 0, subMax = 0; i < A.length; ++i) {
            subMax = maxLength(A, A.length - i -1, B, 0, Math.min(i+1, minSize));
            ans = Math.max(ans, subMax);
        }
        for (int i = 0, subMax = 0; i < B.length; ++i) {
            subMax = maxLength(A, 0, B, B.length - i -1, Math.min(i+1, minSize));
            ans = Math.max(ans, subMax);
        }
        return ans;
    }

    private int maxLength(int[] A, int offsetA, int[] B, int offsetB, int len) {
        int max = 0;
        for (int i = 0, count = 0; i < len; ++i) {
            count = A[i + offsetA] == B[i + offsetB] ? count + 1 : 0;
            max = Math.max(max, count);
        }
        return max;
    }
}
