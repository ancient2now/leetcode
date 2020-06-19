package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class _00000_00500_
{
    @Test
    public void _00289_GameOfLife() {

        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        new _00289_GameOfLife().gameOfLife(board);

        PrintUtils.printMatrix(board);

    }

    @Test
    public void _00125_ValidPalindrome() {
        String q1 = "A man, a plan, a canal: Panama";
        boolean a1 = true;

        String q2 = "race a car";
        boolean a2 = false;

        _00125_ValidPalindrome test = new _00125_ValidPalindrome();
        Assert.assertEquals(test.isPalindrome(q1), a1);
        Assert.assertEquals(test.isPalindrome(q2), a2);
    }

}
