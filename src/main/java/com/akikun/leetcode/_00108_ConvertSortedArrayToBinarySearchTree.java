package com.akikun.leetcode;

import com.akikun.leetcode.struct.TreeNode;

public class _00108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        _00108_ConvertSortedArrayToBinarySearchTree test = new _00108_ConvertSortedArrayToBinarySearchTree();
        test.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[middle]);
        root.left = construct(nums, start, middle - 1);
        root.right = construct(nums, middle + 1, end);
        return root;
    }
}
