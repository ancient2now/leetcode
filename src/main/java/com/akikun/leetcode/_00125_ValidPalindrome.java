package com.akikun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @completed 2020.06.19
 */
public class _00125_ValidPalindrome {
    
    public boolean isPalindrome(String s) { 
        if (s.length() < 2) {
            return true;
        }

        char[] arr = s.toLowerCase().toCharArray();
        List<Character> list  = new ArrayList<>();
        for (char c : arr) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                list.add(c);
            }
        }
        int len = list.size();
        for (int i = 0, j = len - 1; i <= j; ++i, --j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        
        return true;
    }
}