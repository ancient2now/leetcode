package com.akikun.leetcode;

import com.akikun.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _00095_UniqueBinarySearchTreesII {

    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> allList = new ArrayList<>();
        if (left > right) {
            allList.add(null);
            return allList;
        }

        for (int i = left; i <= right; ++i) {
            List<TreeNode> leftList = dfs(left, i - 1);
            List<TreeNode> rightList = dfs(i + 1, right);

            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    allList.add(rootNode);
                }
            }
        }

        return allList;

    }
}
