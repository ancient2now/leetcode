package com.akikun.leetcode;

import java.util.Stack;

public class _01190_ReverseSubstrings {

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        _01190_ReverseSubstrings test = new _01190_ReverseSubstrings();
        String res = test.reverseParentheses(s);
        System.out.println(res);
    }

    public String reverseParentheses(String s) {
        int len = s.length();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(i) == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
