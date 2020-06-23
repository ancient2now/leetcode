package com.akikun.leetcode;

public class _00067_AddBinary {

    public static void main(String[] args) {
        String a = "11111";
        String b = "101";
        _00067_AddBinary test = new _00067_AddBinary();
        String result = test.addBinary(a, b);
        System.err.println(result);
    }

    public String addBinary(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int len = Math.max(A.length, B.length) + 1;
        int[] res = new int[len];
        int add = 0;
        for (int i = 0; i < len; ++i) {
            int curr = 0;
            if (i < A.length) {
                curr += A[A.length - i - 1] - 48;
            }
            if (i < B.length) {
                curr += B[B.length - i - 1] - 48;
            }
            curr += add;
            res[len - i -1] = curr % 2;
            add = curr / 2;
        }

        int i = res[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (; i < len; ++i) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
