package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;

import java.util.Stack;

public class _00865_ScoreOfParentheses {

    public static void main(String[] args) {
        _00865_ScoreOfParentheses test = new _00865_ScoreOfParentheses();
        String s = "(()(()))";
        int ans = test.scoreOfParentheses(s);
        PrintUtils.printAnswer(ans);
        PrintUtils.printAnswer(test.scoreOfParentheses_math(s));
    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }

    public int scoreOfParentheses_math(String S) {
        int ans = 0, bal = 0;

        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(') {
                    ans += 1 << bal;
                }
            }
        }

        return ans;
    }

}
