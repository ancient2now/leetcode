package com.akikun.leetcode.interview;

import com.akikun.leetcode.commons.PrintUtils;

public class _16_11_DivingBoardLCCI {

    public static void main(String[] args) {
        int shorter = 1, longer = 2, k = 3; // Execpted: {3,4,5,6}
        _16_11_DivingBoardLCCI test = new _16_11_DivingBoardLCCI();
        int[] ans = test.divingBoard(shorter, longer, k);
        PrintUtils.printArray(ans);
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};

        int[] ans = new int[k + 1];
        int sub = longer - shorter;
        int ks = shorter * k;
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = ks + sub * i;
        }
        return ans;
    }


}
