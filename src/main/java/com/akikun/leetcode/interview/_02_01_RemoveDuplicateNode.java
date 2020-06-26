package com.akikun.leetcode.interview;

import com.akikun.leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _02_01_RemoveDuplicateNode {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.from(arr1);
        _02_01_RemoveDuplicateNode test = new _02_01_RemoveDuplicateNode();
        ListNode res = test.removeDuplicateNodes(head);
        res.print();
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q;
        Set<Integer> set = new HashSet<>();
        set.add(p.val);
        while ((q = p.next) != null) {
            if (set.contains(q.val)) {
                p.next = q.next;
                continue;
            }
            set.add(q.val);
            p = q;
        }
        return head;
    }
}
