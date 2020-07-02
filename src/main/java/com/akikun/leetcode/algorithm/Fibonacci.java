package com.akikun.leetcode.algorithm;

/**
 * the two solutions of Fibonacci
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        int ans1, ans2;
        long start, end;

        int n = 45;

        start = System.currentTimeMillis();
        ans2 = test.iteration(n);
        end = System.currentTimeMillis();
        System.err.println("iteration answer: " + ans2 +", time: " + (end - start));

        start = System.currentTimeMillis();
        ans1 = test.recursion(n);
        end = System.currentTimeMillis();
        System.err.println("recursion answer: " + ans1 +", time: " + (end - start));
    }

    int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    int iteration(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        n -= 2;

        int a = 1, b = 1;
        int temp;
        for (int i = 0; i < n; ++i) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

}
