package com.akikun.leetcode;

public class _00168_ExcelSheetColumnTitle {

    public static void main(String[] args) {
        _00168_ExcelSheetColumnTitle test = new _00168_ExcelSheetColumnTitle();
        String ans1 = test.convertToTitle(28); // result: AB
        String ans2 = test.convertToTitle(701); // result: ZY
        System.out.println("Answer1:" + ans1 + ", Answer2:" + ans2);
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int k = n % 26;
            sb.insert(0, (char)('A' + k));
            n /= 26;
        }
        return sb.toString();
    }
}
