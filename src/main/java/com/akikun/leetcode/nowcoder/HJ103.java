package com.akikun.leetcode.nowcoder;

import java.util.Scanner;

public class HJ103 {

    // TODO https://www.nowcoder.com/practice/24e6243b9f0446b081b1d6d32f2aa3aa?tpId=37&&tqId=21326&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = Integer.parseInt(scan.nextLine());
        int count = 0;
        int[] arr = new int[len];
        int maxValue = 0;
        while (count < len) {
            arr[count] = Integer.parseInt(scan.nextLine());
            maxValue = Math.max(maxValue, arr[count]);
            count++;
        }
        int ans = 0;
        int i = len;
        while(--i >= 0 && arr[i] < maxValue) { }
        if (i > 0){
            int pre = maxValue;
            ans = 1;
            for (; i >= 0; --i) {
                if (arr[i] < pre) {
                    pre = arr[i];
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
