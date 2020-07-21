package com.akikun.leetcode.nowcoder;

import java.util.Scanner;

public class HJ104 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tail = "00000000";
        while (scan.hasNext()) {
            int n = Integer.parseInt(scan.nextLine());
            int time = 0;
            while (time++ < n) {
                String str = scan.nextLine();
                int len = str.length();
                int loop = len / 8;
                StringBuilder sb = new StringBuilder();
                for (int i = 0, from = 0, end = 8; i < loop; from += 8, i++, end += 8) {
                    sb.append(str, from, end).append("\n");
                }
                int left;
                if ((left = len % 8) != 0) {
                    sb.append(str.substring(len-left))
                            .append(tail.substring(left))
                            .append("\n");
                }
                System.out.print(sb.toString());
            }
        }
    }
}
