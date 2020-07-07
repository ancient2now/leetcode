package com.akikun.leetcode;

import com.akikun.leetcode.struct.TreeNode;

public class _00112_PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int nextSum = sum - root.val;
        if (root.left == null && root.right == null) {
            return nextSum == 0;
        }
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }
}
