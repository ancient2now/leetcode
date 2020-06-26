package com.akikun.leetcode;

import java.util.Arrays;

import com.akikun.leetcode.struct.TreeNode;

public class _00889_ConstructBinaryTreeFromPrePost {

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        _00889_ConstructBinaryTreeFromPrePost test = new _00889_ConstructBinaryTreeFromPrePost();
        test.constructFromPrePost(pre, post);

    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) {
            return root;
        }

        int splitPot = 0;
        for (int i = 0; i < len; ++i) {
            if (post[i] == pre[1]) {
                splitPot = i + 1;
                break;
            }
        }

        root.left = constructFromPrePost(
                Arrays.copyOfRange(pre, 1, splitPot + 1),
                Arrays.copyOfRange(post, 0, splitPot));
        root.right = constructFromPrePost(
                Arrays.copyOfRange(pre, splitPot + 1, len),
                Arrays.copyOfRange(post, splitPot, len - 1));

        return root;
    }

}
