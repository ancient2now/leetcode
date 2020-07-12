package com.akikun.leetcode;

import com.akikun.leetcode.commons.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

public class _00315_CountofSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        _00315_CountofSmallerNumbersAfterSelf test = new _00315_CountofSmallerNumbersAfterSelf();
        int[] nums = {2,0,1}; // Excepted: [2, 0, 0]
        int[] nums2 = {5,2,6,1}; // Excepted: [2,1,1,0]
        PrintUtils.printList(test.countSmaller(nums));
        PrintUtils.printList(test.countSmaller(nums2));
    }

    // Over Time, I'm Sorry
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        TreeMap<Integer, int[]> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = len - 1; i >= 0; --i) {
            Set<Integer> keys = map.keySet();
            boolean noKey = true;
            for (Integer key : keys) {
                int[] temp = map.get(key);
                if (key == nums[i]) {
                    ans[i] = temp[0];
                    temp[1]++;
                    noKey = false;
                    break;
                } else if (key > nums[i]) {
                    temp[0] += 1;
                } else if (key < nums[i]) {
                    ans[i] = temp[0] + temp[1];
                    map.put(nums[i], new int[]{ans[i], 1});
                    noKey = false;
                    break;
                }
            }
            if (noKey) {
                map.put(nums[i], new int[]{0, 1});
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
