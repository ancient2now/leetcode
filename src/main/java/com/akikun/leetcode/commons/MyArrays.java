package com.akikun.leetcode.commons;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyArrays {

    /**
     * 打印数组
     * @param arr 数组
     * @param <E> 数组元素的类型
     */
    public static <E> void print(E[] arr) {
        String arrStr = java.util.Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("length:" + arr.length + "; values:" + arrStr);
    }

    /**
     * 将int数组转化成Integer类型的List
     * @param arr int数组
     * @return Integer列表
     */
    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 随机生成素组, 数组的值都是随机整数
     * @param len 数组的长度
     * @return 一个随机生成的数组
     */
    public static int[] random(int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static int[] randomPositive(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            arr[i] = (int) ((Math.random() * 9 + 1) * 10000000);
        }
        return arr;
    }

    /**
     * 随机生成素组, 数组的值都是随机整数
     * @param len 数组的长度
     * @param round 随机数的大小范围
     * @return 一个随机生成的数组
     */
    public static int[] random(int len, int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }

        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            arr[i] = random.nextInt(round);
        }
        return arr;
    }

}
